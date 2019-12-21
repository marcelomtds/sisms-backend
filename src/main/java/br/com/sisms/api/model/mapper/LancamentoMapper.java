package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.entity.Lancamento;
import br.com.sisms.api.model.request.LancamentoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AtendimentoMapper.class, PacoteMapper.class, CategoriaLancamentoMapper.class, FormaPagamentoMapper.class})
public interface LancamentoMapper extends BaseMapper<Lancamento, LancamentoDTO> {

    @Mapping(source = "atendimentoId", target = "atendimento.id")
    @Mapping(source = "pacoteId", target = "pacote.id")
    @Mapping(source = "categoriaLancamentoId", target = "categoriaLancamento.id")
    @Mapping(source = "formaPagamentoId", target = "formaPagamento.id")
    Lancamento toEntity(LancamentoRequest request);

    @Mapping(source = "atendimentoId", target = "atendimento.id")
    @Mapping(source = "pacoteId", target = "pacote.id")
    @Mapping(source = "categoriaLancamentoId", target = "categoriaLancamento.id")
    @Mapping(source = "formaPagamentoId", target = "formaPagamento.id")
    LancamentoDTO toDTO(LancamentoRequest request);

}
