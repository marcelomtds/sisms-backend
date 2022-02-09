package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.dto.LancamentoTotalDTO;
import br.com.sisms.api.model.dto.PacoteDTO;
import br.com.sisms.api.model.entity.Lancamento;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.enums.PerfilEnum;
import br.com.sisms.api.model.enums.TipoLancamentoEnum;
import br.com.sisms.api.model.filter.LancamentoFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.LancamentoMapper;
import br.com.sisms.api.repository.LancamentoRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LancamentoService {

    private final LancamentoRepository repository;
    private final AtendimentoService atendimentoService;
    private final PacoteService pacoteService;
    private final CategoriaLancamentoService categoriaLancamentoService;
    private final FormaPagamentoService formaPagamentoService;
    private final UsuarioService usuarioService;
    private final PacienteService pacienteService;
    private final TipoLancamentoService tipoLancamentoService;
    private final LancamentoMapper mapper;

    public LancamentoDTO createOrUpdate(final Long id, final LancamentoDTO dtoSource) {
        validateResources(dtoSource);
        checkPackageValue(dtoSource);
        checkBalanceAmount(dtoSource);
        checkEdit(dtoSource);
        Lancamento entity;
        if (Objects.nonNull(id)) {
            LancamentoDTO dtoTarget = findByIdWithPermission(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "usuarioId", "atendimentoId", "pacoteId", "tipoLancamentoId", "tipoAtendimentoId", "pacienteId", dtoTarget.getTipoLancamentoId() == TipoLancamentoEnum.UTILIZACAO_CREDITO.getTipoLancamento() ? "formaPagamentoId" : "");
            entity = mapper.toEntity(dtoTarget);
        } else {
            dtoSource.setUsuarioId(usuarioService.getCurrentSessionUser().getId());
            entity = mapper.toEntity(dtoSource);
        }
        if (Objects.isNull(entity.getAtendimento().getId())) {
            entity.setAtendimento(null);
        }
        if (Objects.isNull(entity.getPacote().getId())) {
            entity.setPacote(null);
        }
        if (Objects.isNull(entity.getCategoriaLancamento().getId())) {
            entity.setCategoriaLancamento(null);
        }
        if (Objects.isNull(entity.getTipoAtendimento().getId())) {
            entity.setTipoAtendimento(null);
        }
        if (Objects.isNull(entity.getPaciente().getId())) {
            entity.setPaciente(null);
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public LancamentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0047.toString())));
    }

    @Transactional(readOnly = true)
    public LancamentoDTO findByIdWithPermission(final Long id) {
        LancamentoDTO dto = findById(id);
        checkUserPermission(dto);
        return dto;
    }

    @Transactional(readOnly = true)
    public BigDecimal findPatientBalance(final Long id) {
        return repository.findPatientBalance(id);
    }

    @Transactional(readOnly = true)
    public List<LancamentoDTO> findExtractByPatient(final Long id) {
        return mapper.toDTO(repository.findExtractByPatient(id));
    }

    public void delete(final Long id) {
        LancamentoDTO lancamentoDTO = findByIdWithPermission(id);
        checkDelete(lancamentoDTO);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<LancamentoDTO> findByFilter(final PageableFilter<LancamentoFilter> filter) {
        return find(filter, filter.getPageSize(), filter.getCurrentPage());
    }

    @Transactional(readOnly = true)
    public LancamentoTotalDTO findTotalByFilter(final PageableFilter<LancamentoFilter> filter) {
        BigDecimal entrada = new BigDecimal(0);
        BigDecimal saida = new BigDecimal(0);
        for (LancamentoDTO dto : find(filter, Integer.MAX_VALUE, 0).getContent()) {
            if (dto.getTipoLancamentoId().equals(TipoLancamentoEnum.ENTRADA.getTipoLancamento()) || dto.getTipoLancamentoId().equals(TipoLancamentoEnum.ENTRADA_CREDITO.getTipoLancamento())) {
                entrada = entrada.add(dto.getValor());
            } else if (dto.getTipoLancamentoId().equals(TipoLancamentoEnum.SAIDA.getTipoLancamento())) {
                saida = saida.add(dto.getValor());
            }
        }
        return new LancamentoTotalDTO(entrada, saida, entrada.subtract(saida));
    }

    private void checkUserPermission(final LancamentoDTO lancamentoDTO) {
        Usuario usuario = usuarioService.getCurrentSessionUser();
        if (!lancamentoDTO.getUsuarioId().equals(usuario.getId()) && usuario.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            throw new AccessDeniedException(MessageEnum.MSG0036.toString());
        }
    }

    private Page<LancamentoDTO> find(final PageableFilter<LancamentoFilter> filter, final Integer size, final Integer currentPage) {
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        Pageable pageable = PageRequest.of(
                currentPage,
                size,
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new LancamentoFilter() : filter.getFilter());
        validatePeriod(filter.getFilter().getDataInicio(), filter.getFilter().getDataFim());
        if (Objects.isNull(filter.getFilter().getTipoLancamentoIds()) || filter.getFilter().getTipoLancamentoIds().size() == 0) {
            filter.getFilter().setTipoLancamentoIds(tipoLancamentoService.findAll().stream().map(result -> result.getId()).collect(Collectors.toList()));
        }
        return repository.findByFilter(
                filter.getFilter().getTipoAtendimentoId(),
                filter.getFilter().getPacoteId(),
                filter.getFilter().getAtendimentoId(),
                filter.getFilter().getTipoLancamentoIds(),
                filter.getFilter().getPacienteId(),
                filter.getFilter().getFormaPagamentoId(),
                filter.getFilter().getCategoriaAtendimentoId(),
                filter.getFilter().getUsuarioId(),
                filter.getFilter().getCategoriaLancamentoId(),
                filter.getFilter().getDataInicio(),
                filter.getFilter().getDataFim(),
                pageable).map(mapper::toDTO);
    }

    private void validatePeriod(final LocalDate dataInicio, final LocalDate dataFim) {
        if (Objects.nonNull(dataInicio) && Objects.nonNull(dataFim) && Util.isInvalidPeriod(dataInicio, dataFim)) {
            throw new BusinessException(MessageEnum.MSG0008.toString());
        }
    }

    private void validateResources(final LancamentoDTO dto) {
        if (Objects.nonNull(dto.getAtendimentoId())) {
            atendimentoService.findByIdWithPermission(dto.getAtendimentoId());
        }
        if (Objects.nonNull(dto.getPacoteId())) {
            pacoteService.findByIdWithPermission(dto.getPacoteId());
        }
        if (Objects.nonNull(dto.getCategoriaLancamentoId())) {
            categoriaLancamentoService.findById(dto.getCategoriaLancamentoId());
        }
        if (Objects.nonNull(dto.getPacienteId())) {
            pacienteService.findById(dto.getPacienteId());
        }
        formaPagamentoService.findById(dto.getFormaPagamentoId());
        tipoLancamentoService.findById(dto.getTipoLancamentoId());
    }

    private void checkPackageValue(final LancamentoDTO lancamentoDTO) {
        if (Objects.nonNull(lancamentoDTO.getPacoteId())) {
            final PacoteDTO pacoteDTO = pacoteService.findById(lancamentoDTO.getPacoteId());
            BigDecimal totalPago = Objects.isNull(pacoteDTO.getTotalPago()) ? BigDecimal.valueOf(0) : pacoteDTO.getTotalPago();
            if (Objects.nonNull(lancamentoDTO.getId())) {
                BigDecimal valorAnterior = findById(lancamentoDTO.getId()).getValor();
                totalPago = totalPago.subtract(valorAnterior);
            }
            if (lancamentoDTO.getValor().add(totalPago).compareTo(pacoteDTO.getValor()) == 1) {
                throw new BusinessException(MessageEnum.MSG0080.toString());
            }
        }
    }

    private void checkBalanceAmount(final LancamentoDTO lancamentoDTO) {
        if (lancamentoDTO.getTipoLancamentoId() == TipoLancamentoEnum.UTILIZACAO_CREDITO.getTipoLancamento()) {
            BigDecimal saldo = repository.findPatientBalance(lancamentoDTO.getPacienteId());
            if(Objects.isNull(saldo)) {
                saldo = new BigDecimal(0);
            }
            if (Objects.nonNull(lancamentoDTO.getId())) {
                BigDecimal valorAnterior = findById(lancamentoDTO.getId()).getValor();
                saldo = saldo.add(valorAnterior);
            }
            if (lancamentoDTO.getValor().compareTo(saldo) == 1) {
                throw new BusinessException(MessageEnum.MSG0084.toString());
            }
        }
    }

    private void checkDelete(final LancamentoDTO lancamentoDTO) {
        if (lancamentoDTO.getTipoLancamentoId() == TipoLancamentoEnum.ENTRADA_CREDITO.getTipoLancamento()) {
            BigDecimal saldo = repository.findPatientBalance(lancamentoDTO.getPacienteId());
            if(Objects.isNull(saldo)) {
                saldo = new BigDecimal(0);
            }
            if (saldo.compareTo(lancamentoDTO.getValor()) == -1) {
                throw new BusinessException(MessageEnum.MSG0086.toString());
            }
        }
    }

    private void checkEdit(final LancamentoDTO lancamentoDTO) {
        if (lancamentoDTO.getTipoLancamentoId() == TipoLancamentoEnum.ENTRADA_CREDITO.getTipoLancamento() && Objects.nonNull(lancamentoDTO.getId())) {
            BigDecimal saldo = repository.findPatientBalance(lancamentoDTO.getPacienteId());
            if(Objects.isNull(saldo)) {
                saldo = new BigDecimal(0);
            }
            BigDecimal valorAnterior = findById(lancamentoDTO.getId()).getValor();
            saldo = saldo.subtract(valorAnterior).add(lancamentoDTO.getValor());
            if (saldo.compareTo(new BigDecimal(0)) == -1) {
                final String valor = (saldo.multiply(new BigDecimal(-1)).add(lancamentoDTO.getValor())).toString();
                throw new BusinessException(MessageEnum.MSG0087.messageWithParameters(valor));
            }
        }
    }
}
