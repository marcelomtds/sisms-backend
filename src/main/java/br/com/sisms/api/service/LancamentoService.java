package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.filter.LancamentoFilter;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.dto.LancamentoTotalResultDTO;
import br.com.sisms.api.model.entity.Lancamento;
import br.com.sisms.api.model.entity.TipoLancamento;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.enums.TipoLancamentoEnum;
import br.com.sisms.api.model.mapper.LancamentoMapper;
import br.com.sisms.api.model.request.LancamentoRequest;
import br.com.sisms.api.repository.LancamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    private final LancamentoMapper mapper;

    public LancamentoDTO createOrUpdate(final Long id, final LancamentoRequest request) {
        validateResources(request);
        validateRequest(request);
        Lancamento entity;
        if (Objects.nonNull(id)) {
            LancamentoDTO dto = findById(id);
            BeanUtils.copyProperties(mapper.toDTO(request), dto);
            entity = mapper.toEntity(dto);
        } else {
            entity = mapper.toEntity(request);
            usuarioService.getCurrentSessionUser().getId();
            entity.setUsuario(usuarioService.getCurrentSessionUser());
        }
        entity.setTipoLancamento(checkReleaseType(entity.getCategoriaLancamento().getId()));
        if (Objects.isNull(entity.getAtendimento().getId())) {
            entity.setAtendimento(null);
        }
        if (Objects.isNull(entity.getPacote().getId())) {
            entity.setPacote(null);
        }
        if (Objects.isNull(entity.getCategoriaLancamento().getId())) {
            entity.setCategoriaLancamento(null);
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public LancamentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.LANCAMENTO_NAO_ENCONTRADO.toString())));
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<LancamentoDTO> findByFilter(final PageableFilter<LancamentoFilter> filter) {
        return find(filter, filter.getPageSize());
    }

    @Transactional(readOnly = true)
    public LancamentoTotalResultDTO findTotalByFilter(final PageableFilter<LancamentoFilter> filter) {
        BigDecimal entrada = new BigDecimal(0);
        BigDecimal saida = new BigDecimal(0);
        for (LancamentoDTO dto : find(filter, Integer.MAX_VALUE).getContent()) {
            if (dto.getTipoLancamento().getId().equals(1L)) {
                entrada = entrada.add(dto.getValor());
            } else {
                saida = saida.add(dto.getValor());
            }
        }
        return new LancamentoTotalResultDTO(entrada, saida, entrada.subtract(saida));
    }

    private Page<LancamentoDTO> find(final PageableFilter<LancamentoFilter> filter, final Integer size) {
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                size,
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new LancamentoFilter() : filter.getFilter());
        return repository.findByFilter(
                filter.getFilter().getPacoteId(),
                filter.getFilter().getAtendimentoId(),
                filter.getFilter().getTipoLancamento(),
                filter.getFilter().getPacienteId(),
                filter.getFilter().getFormaPagamentoId(),
                filter.getFilter().getCategoriaAtendimentoId(),
                filter.getFilter().getDataInicio(),
                filter.getFilter().getDataFim(),
                pageable).map(mapper::toDTO);
    }

    private void validateResources(final LancamentoRequest request) {
        if (Objects.nonNull(request.getAtendimentoId())) {
            atendimentoService.findById(request.getAtendimentoId());
        }
        if (Objects.nonNull(request.getPacoteId())) {
            pacoteService.findById(request.getPacoteId());
        }
        if (Objects.nonNull(request.getCategoriaLancamentoId())) {
            categoriaLancamentoService.findById(request.getCategoriaLancamentoId());
        }
        formaPagamentoService.findById(request.getFormaPagamentoId());
    }

    private TipoLancamento checkReleaseType(final Long categoriaLancamentoId) {
        TipoLancamento entity = new TipoLancamento();
        entity.setId(Objects.isNull(categoriaLancamentoId) ? TipoLancamentoEnum.ENTRADA.getTipoLancamento() : TipoLancamentoEnum.SAIDA.getTipoLancamento());
        return entity;
    }

    private void validateRequest(final LancamentoRequest request) {
        if ((Objects.nonNull(request.getAtendimentoId()) && Objects.nonNull(request.getPacoteId()))
                || (Objects.nonNull(request.getAtendimentoId()) && Objects.nonNull(request.getCategoriaLancamentoId()))
                || (Objects.nonNull(request.getPacoteId()) && Objects.nonNull(request.getCategoriaLancamentoId()))
                || (Objects.nonNull(request.getAtendimentoId()) && Objects.nonNull(request.getPacoteId()) && Objects.nonNull(request.getCategoriaLancamentoId()))
                || (Objects.isNull(request.getAtendimentoId()) && Objects.isNull(request.getPacoteId()) && Objects.isNull(request.getCategoriaLancamentoId()))) {
            throw new BusinessException(MessageEnum.CAMPOS_INCONSISTENTES.toString());
        }
    }

}
