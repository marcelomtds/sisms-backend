package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.PacoteDTO;
import br.com.sisms.api.model.entity.Pacote;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.enums.PerfilEnum;
import br.com.sisms.api.model.filter.PacoteFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.PacoteMapper;
import br.com.sisms.api.repository.PacoteRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class PacoteService {

    private final PacoteRepository repository;
    private final PacoteMapper mapper;
    private final PacienteService pacienteService;
    private final CategoriaAtendimentoService categoriaAtendimentoService;
    private final UsuarioService usuarioService;

    public PacoteDTO createOrUpdate(final Long id, final PacoteDTO dtoSource) {
        validateResources(dtoSource);
        Pacote entity;
        if (Objects.nonNull(id)) {
            PacoteDTO dto = findByIdWithPermission(id);
            checkUpdate(dto.getAberto());
            dto.setValor(dtoSource.getValor());
            dto.setQuantidadeSessao(dtoSource.getQuantidadeSessao());
            checkPackageValue(dto);
            checkPackageLimit(dto);
            entity = mapper.toEntity(dto);
        } else {
            entity = mapper.toEntity(dtoSource);
            entity.setUsuario(usuarioService.getCurrentSessionUser());
            Pacote last = repository.findFirstByCategoriaAtendimentoIdAndPacienteIdOrderByNumeroDesc(dtoSource.getCategoriaAtendimentoId(), dtoSource.getPacienteId());
            if (Objects.nonNull(last)) {
                if (last.getAberto()) {
                    checkUserPermissionTerminatePackage(mapper.toDTO(last));
                    last.setAberto(Boolean.FALSE);
                    last = repository.save(last);
                }
                entity.setNumero(last.getNumero() + 1L);
            } else {
                entity.setNumero(1L);
            }
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public PacoteDTO findByIdWithPermission(final Long id) {
        PacoteDTO dto = findById(id);
        checkUserPermission(dto);
        return dto;
    }

    @Transactional(readOnly = true)
    public PacoteDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0045.toString())));
    }

    public PacoteDTO closePackage(final Long id) {
        PacoteDTO dto = findByIdWithPermission(id);
        dto.setAberto(Boolean.FALSE);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public PacoteDTO findLastOpen(final Long categoriaAtendimentoId, final Long pacienteId) {
        return mapper.toDTO(repository.findFirstByCategoriaAtendimentoIdAndPacienteIdAndAbertoIsTrueOrderByNumeroDesc(categoriaAtendimentoId, pacienteId));
    }

    @Transactional(readOnly = true)
    public Page<PacoteDTO> findByFilter(final PageableFilter<PacoteFilter> filter) {
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new PacoteFilter() : filter.getFilter());
        validatePeriod(filter.getFilter().getDataInicio(), filter.getFilter().getDataFim());
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        Usuario user = usuarioService.getCurrentSessionUser();
        if (user.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            filter.getFilter().setUsuarioId(user.getId());
        }
        return repository.findByFilter(
                filter.getFilter().getCategoriaAtendimentoId(),
                filter.getFilter().getPacienteId(),
                filter.getFilter().getUsuarioId(),
                filter.getFilter().getAberto(),
                filter.getFilter().getDataInicio(),
                filter.getFilter().getDataFim(),
                pageable).map(mapper::toDTO);
    }

    private void checkUserPermission(final PacoteDTO dto) {
        Usuario user = usuarioService.getCurrentSessionUser();
        if (!dto.getUsuarioId().equals(user.getId()) && user.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private void checkUserPermissionTerminatePackage(final PacoteDTO dto) {
        Usuario user = usuarioService.getCurrentSessionUser();
        if (!dto.getUsuarioId().equals(user.getId()) && user.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new BusinessException(MessageEnum.MSG0055.toString());
        }
    }

    private void validateResources(final PacoteDTO dto) {
        pacienteService.findById(dto.getPacienteId());
        categoriaAtendimentoService.findById(dto.getCategoriaAtendimentoId());
    }

    private void validatePeriod(final LocalDate startDate, final LocalDate endDate) {
        if (Objects.nonNull(startDate) && Objects.nonNull(endDate) && Util.isInvalidPeriod(startDate, endDate)) {
            throw new BusinessException(MessageEnum.MSG0008.toString());
        }
    }

    private void checkUpdate(final Boolean aberto) {
        if (BooleanUtils.isFalse(aberto)) {
            throw new BusinessException(MessageEnum.MSG0038.toString());
        }
    }

    private void checkPackageLimit(final PacoteDTO pacoteDTO) {
        if (Objects.nonNull(pacoteDTO.getQuantidadeSessao()) && pacoteDTO.getQuantidadeSessao() < pacoteDTO.getQuantidadeAtendimentos()) {
            throw new BusinessException(MessageEnum.MSG0079.toString());
        }
    }

    private void checkPackageValue(final PacoteDTO pacoteDTO) {
        if (Objects.nonNull(pacoteDTO.getTotalPago()) && pacoteDTO.getValor().compareTo(pacoteDTO.getTotalPago()) == -1) {
            throw new BusinessException(MessageEnum.MSG0081.messageWithParameters(NumberFormat.getCurrencyInstance().format(pacoteDTO.getTotalPago())));
        }
    }

}
