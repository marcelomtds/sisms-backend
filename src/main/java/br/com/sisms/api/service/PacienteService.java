package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.filter.PacienteUsuarioFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.PacienteDTO;
import br.com.sisms.api.model.entity.Paciente;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.PacienteMapper;
import br.com.sisms.api.model.request.PacienteRequest;
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
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.PACIENTE_NAO_ENCONTRADO.toString())));
    }

    public PacienteDTO activeOrInative(final Long id) {
        PacienteDTO dto = findById(id);
        dto.setAtivo(BooleanUtils.negate(dto.getAtivo()));
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public PacienteDTO createOrUpdate(final Long id, final PacienteRequest request) {
        validateResources(request);
        checkDate(request.getDataNascimento());
        Paciente entity;
        if (!ObjectUtils.isEmpty(id)) {
            PacienteDTO dto = findById(id);
            BeanUtils.copyProperties(mapper.toDTO(request), dto, "id", "cpf", "rg", "ativo", "contatoId", "enderecoId");
            entity = mapper.toEntity(dto);
        } else {
            entity = mapper.toEntity(request);
        }
        validateCpf(entity.getCpf());
        validateDuplicityByCpf(entity);
        if (Objects.isNull(entity.getProfissao().getId())) {
            entity.setProfissao(null);
        }
        return mapper.toDTO(repository.save(entity));
    }

    private void validateDuplicityByCpf(final Paciente entity) {
        if (StringUtils.isNotBlank(entity.getCpf())) {
            final PacienteDTO dto = mapper.toDTO(repository.findByCpf(entity.getCpf()));
            if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
                throw new BusinessException(MessageEnum.MSG0006.toString());
            }
        }
    }

    private void validateCpf(final String cpf) {
        if (StringUtils.isNotBlank(cpf) && !Util.isValidCpf(cpf)) {
            throw new BusinessException(MessageEnum.CPF_INVALIDO.toString());
        }
    }

    private void validateResources(final PacienteRequest request) {
        if (!ObjectUtils.isEmpty(request.getProfissaoId())) {
            profissaoService.findById(request.getProfissaoId());
        }
        sexoService.findById(request.getSexoId());
        localidadeService.findById(request.getEnderecoLocalidadeId());
    }

    private void checkDate(final LocalDate date) {
        if (Util.isCurrentDateBeforeDate(date)) {
            throw new BusinessException(MessageEnum.DATA_NASCIMENTO_MAIOR_ATUAL.toString());
        }
    }

}
