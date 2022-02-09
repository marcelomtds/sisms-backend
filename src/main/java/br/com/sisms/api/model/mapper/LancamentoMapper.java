package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.LancamentoDTO;
import br.com.sisms.api.model.entity.Lancamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UsuarioMapper.class, AtendimentoMapper.class, PacoteMapper.class, CategoriaLancamentoMapper.class, FormaPagamentoMapper.class, TipoLancamentoMapper.class})
public interface LancamentoMapper extends BaseMapper<Lancamento, LancamentoDTO> {

    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "usuarioNomeCompleto", target = "usuario.nomeCompleto")
    @Mapping(source = "atendimentoId", target = "atendimento.id")
    @Mapping(source = "atendimentoPacienteNomeCompleto", target = "atendimento.paciente.nomeCompleto")
    @Mapping(source = "pacotePacienteNomeCompleto", target = "pacote.paciente.nomeCompleto")
    @Mapping(source = "pacoteId", target = "pacote.id")
    @Mapping(source = "categoriaLancamentoId", target = "categoriaLancamento.id")
    @Mapping(source = "categoriaLancamentoDescricao", target = "categoriaLancamento.descricao")
    @Mapping(source = "formaPagamentoId", target = "formaPagamento.id")
    @Mapping(source = "formaPagamentoDescricao", target = "formaPagamento.descricao")
    @Mapping(source = "tipoLancamentoId", target = "tipoLancamento.id")
    @Mapping(source = "tipoLancamentoDescricao", target = "tipoLancamento.descricao")
    @Mapping(source = "tipoAtendimentoId", target = "tipoAtendimento.id")
    @Mapping(source = "tipoAtendimentoDescricao", target = "tipoAtendimento.descricao")
    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    @Mapping(source = "atendimentoCategoriaAtendimentoDescricao", target = "atendimento.categoriaAtendimento.descricao")
    @Mapping(source = "pacoteCategoriaAtendimentoDescricao", target = "pacote.categoriaAtendimento.descricao")
    Lancamento toEntity(LancamentoDTO dto);

    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNomeCompleto", source = "usuario.nomeCompleto")
    @Mapping(target = "atendimentoId", source = "atendimento.id")
    @Mapping(target = "atendimentoPacienteNomeCompleto", source = "atendimento.paciente.nomeCompleto")
    @Mapping(target = "pacotePacienteNomeCompleto", source = "pacote.paciente.nomeCompleto")
    @Mapping(target = "pacoteId", source = "pacote.id")
    @Mapping(target = "categoriaLancamentoId", source = "categoriaLancamento.id")
    @Mapping(target = "categoriaLancamentoDescricao", source = "categoriaLancamento.descricao")
    @Mapping(target = "formaPagamentoId", source = "formaPagamento.id")
    @Mapping(target = "formaPagamentoDescricao", source = "formaPagamento.descricao")
    @Mapping(target = "tipoLancamentoId", source = "tipoLancamento.id")
    @Mapping(target = "tipoLancamentoDescricao", source = "tipoLancamento.descricao")
    @Mapping(target = "tipoAtendimentoId", source = "tipoAtendimento.id")
    @Mapping(target = "tipoAtendimentoDescricao", source = "tipoAtendimento.descricao")
    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    @Mapping(target = "atendimentoCategoriaAtendimentoDescricao", source = "atendimento.categoriaAtendimento.descricao")
    @Mapping(target = "pacoteCategoriaAtendimentoDescricao", source = "pacote.categoriaAtendimento.descricao")
    LancamentoDTO toDTO(Lancamento entity);

}
