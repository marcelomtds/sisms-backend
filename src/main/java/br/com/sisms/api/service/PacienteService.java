package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.PacienteDTO;
import br.com.sisms.api.model.entity.Paciente;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PacienteUsuarioFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.PacienteMapper;
import br.com.sisms.api.repository.PacienteRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;
    private final ProfissaoService profissaoService;
    private final SexoService sexoService;
    private final LocalidadeService localidadeService;

    @Transactional(readOnly = true)
    public Page<PacienteDTO> findByFilter(final PageableFilter<PacienteUsuarioFilter> filter) {
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new PacienteUsuarioFilter() : filter.getFilter());
        return repository.findByFilter(
                filter.getFilter().getNomeCompleto(),
                filter.getFilter().getCpf(),
                filter.getFilter().getAtivo(),
                filter.getFilter().getSexoId(),
                filter.getFilter().getLocalidadeId(),
                filter.getFilter().getUfId(),
                filter.getFilter().getCelular(),
                filter.getFilter().getCelularRecado(),
                filter.getFilter().getResidencial(),
                filter.getFilter().getComercial(),
                pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public List<PacienteDTO> findAllActive() {
        return mapper.toDTO(repository.findAllByAtivoIsTrueOrderByNomeCompletoAsc());
    }

    @Transactional(readOnly = true)
    public List<PacienteDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Transactional(readOnly = true)
    public PacienteDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG00044.toString())));
    }

    public PacienteDTO activeOrInative(final Long id) {
        PacienteDTO dto = findById(id);
        dto.setAtivo(BooleanUtils.negate(dto.getAtivo()));
        Paciente entity = mapper.toEntity(dto);
        if (Objects.isNull(entity.getProfissao().getId())) {
            entity.setProfissao(null);
        }
        return mapper.toDTO(repository.save(entity));
    }

    public PacienteDTO createOrUpdate(final Long id, final PacienteDTO dtoSource) {
        validateResources(dtoSource);
        checkDate(dtoSource.getDataNascimento());
        validateTelefoneContato(dtoSource);
        Paciente entity;
        if (!ObjectUtils.isEmpty(id)) {
            PacienteDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", StringUtils.isBlank(dtoSource.getCpf()) ? "cpf" : "", "rg", "ativo", "contatoId", "enderecoId");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByCpf(entity);
        if (Objects.isNull(entity.getProfissao().getId())) {
            entity.setProfissao(null);
        }
        return mapper.toDTO(repository.save(entity));
    }

    private void validateTelefoneContato(final PacienteDTO dto) {
        if (StringUtils.isBlank(dto.getContatoCelular()) && StringUtils.isBlank(dto.getContatoCelularRecado())
                && StringUtils.isBlank(dto.getContatoResidencial()) && StringUtils.isBlank(dto.getContatoComercial())) {
            throw new BusinessException(MessageEnum.MSG0007.toString());
        }
    }

    private void validateDuplicityByCpf(final Paciente entity) {
        if (StringUtils.isNotBlank(entity.getCpf())) {
            final PacienteDTO dto = mapper.toDTO(repository.findByCpf(entity.getCpf()));
            if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
                throw new BusinessException(MessageEnum.MSG0006.toString());
            }
        }
    }

    private void validateResources(final PacienteDTO dto) {
        if (!ObjectUtils.isEmpty(dto.getProfissaoId())) {
            profissaoService.findById(dto.getProfissaoId());
        }
        sexoService.findById(dto.getSexoId());
        localidadeService.findById(dto.getEnderecoLocalidadeId());
    }

    private void checkDate(final LocalDate date) {
        if (Util.isCurrentDateBeforeDate(date)) {
            throw new BusinessException(MessageEnum.MSG00037.toString());
        }
    }

}
