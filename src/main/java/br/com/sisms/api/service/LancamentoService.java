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
import br.com.sisms.api.model.enums.TipoAtendimentoEnum;
import br.com.sisms.api.model.enums.TipoLancamentoEnum;
import br.com.sisms.api.model.filter.LancamentoFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.LancamentoMapper;
import br.com.sisms.api.repository.LancamentoRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
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
    private final LancamentoMapper mapper;

    public LancamentoDTO createOrUpdate(final Long id, final LancamentoDTO dtoSource) {
        validateResources(dtoSource);
        checkPackageValue(dtoSource);
        Lancamento entity;
        if (Objects.nonNull(id)) {
            LancamentoDTO dtoTarget = findByIdWithPermission(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "usuarioId", "atendimentoId", "pacoteId", "tipoLancamentoId", "tipoAtendimentoId", "credito", "pacienteId");
            entity = mapper.toEntity(dtoTarget);
        } else {
            dtoSource.setUsuarioId(usuarioService.getCurrentSessionUser().getId());
            // TODO simplificar, mandando os parametros do front-end
            if (Objects.isNull(dtoSource.getCategoriaLancamentoId())) {
                dtoSource.setTipoLancamentoId(TipoLancamentoEnum.ENTRADA.getTipoLancamento());
                if(BooleanUtils.isFalse(dtoSource.getCredito())){
                    dtoSource.setTipoAtendimentoId(Objects.nonNull(dtoSource.getPacoteId()) ? TipoAtendimentoEnum.PACOTE.getTipoAtendimento() : TipoAtendimentoEnum.SESSAO.getTipoAtendimento());
                    if(dtoSource.getTipoAtendimentoId().equals(TipoAtendimentoEnum.SESSAO)){
                        dtoSource.setPacienteId(atendimentoService.findById(dtoSource.getAtendimentoId()).getPacienteId());
                    } else {
                        dtoSource.setPacienteId(pacoteService.findById(dtoSource.getPacoteId()).getPacienteId());
                    }
                }
            } else {
                dtoSource.setTipoLancamentoId(TipoLancamentoEnum.SAIDA.getTipoLancamento());
            }
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
        // TODO verificar porque o padrao da coluna credito nao esta inserindo false
        entity.setCredito(Objects.isNull(entity.getCredito()) ? false : true);
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
    public List<LancamentoDTO> findPatientCredit(final Long id) {
        return mapper.toDTO(repository.findPatientCredit(id));
    }

    public void delete(final Long id) {
        findByIdWithPermission(id);
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
            if (dto.getTipoLancamentoId().equals(TipoLancamentoEnum.ENTRADA.getTipoLancamento())) {
                entrada = entrada.add(dto.getValor());
            } else {
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
        return repository.findByFilter(
                filter.getFilter().getTipoAtendimentoId(),
                filter.getFilter().getPacoteId(),
                filter.getFilter().getAtendimentoId(),
                filter.getFilter().getTipoLancamentoId(),
                filter.getFilter().getPacienteId(),
                filter.getFilter().getFormaPagamentoId(),
                filter.getFilter().getCategoriaAtendimentoId(),
                filter.getFilter().getUsuarioId(),
                filter.getFilter().getCategoriaLancamentoId(),
                filter.getFilter().getDataInicio(),
                filter.getFilter().getDataFim(),
                filter.getFilter().getCredito(),
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
    }

    private void checkPackageValue(final LancamentoDTO lancamentoDTO) {
        if (Objects.nonNull(lancamentoDTO.getPacoteId())) {
            final PacoteDTO pacoteDTO = pacoteService.findById(lancamentoDTO.getPacoteId());
            BigDecimal totalPago = Objects.isNull(pacoteDTO.getTotalPago()) ? BigDecimal.valueOf(0) : pacoteDTO.getTotalPago();
            BigDecimal valorAnterior;
            if (Objects.nonNull(lancamentoDTO.getId())) {
                valorAnterior = findById(lancamentoDTO.getId()).getValor();
                totalPago = totalPago.subtract(valorAnterior);
            }
            if (lancamentoDTO.getValor().add(totalPago).compareTo(pacoteDTO.getValor()) == 1) {
                throw new BusinessException(MessageEnum.MSG0080.toString());
            }
        }
    }

}
