package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.AtendimentoDTO;
import br.com.sisms.api.model.entity.Atendimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {
        PacoteMapper.class, UsuarioMapper.class, PacienteMapper.class,
        PreAtendimentoMapper.class, PosAtendimentoMapper.class,
        CategoriaLancamentoMapper.class, ImagemAtendimentoMapper.class,
        PreAtendimentoOutraMedidaMapper.class, PosAtendimentoOutraMedidaMapper.class})
public interface AtendimentoMapper extends BaseMapper<Atendimento, AtendimentoDTO> {

    @Mapping(target = "pacoteId", source = "pacote.id")
    @Mapping(target = "pacoteNumero", source = "pacote.numero")
    @Mapping(target = "pacoteValor", source = "pacote.valor")
    @Mapping(target = "pacoteTotalPago", source = "pacote.totalPago")
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNomeCompleto", source = "usuario.nomeCompleto")
    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    @Mapping(target = "preAtendimentoId", source = "preAtendimento.id")
    @Mapping(target = "preAtendimentoData", source = "preAtendimento.data")
    @Mapping(target = "preAtendimentoPressaoArterial", source = "preAtendimento.pressaoArterial")
    @Mapping(target = "preAtendimentoPeso", source = "preAtendimento.peso")
    @Mapping(target = "preAtendimentoSupraUmbilical", source = "preAtendimento.supraUmbilical")
    @Mapping(target = "preAtendimentoLinhaUmbilical", source = "preAtendimento.linhaUmbilical")
    @Mapping(target = "preAtendimentoInfraUmbilical", source = "preAtendimento.infraUmbilical")
    @Mapping(target = "preAtendimentoOutrasMedidas", source = "preAtendimento.preAtendimentoOutrasMedidas")
    @Mapping(target = "preAtendimentoObservacao", source = "preAtendimento.observacao")
    @Mapping(target = "posAtendimentoId", source = "posAtendimento.id")
    @Mapping(target = "posAtendimentoData", source = "posAtendimento.data")
    @Mapping(target = "posAtendimentoPressaoArterial", source = "posAtendimento.pressaoArterial")
    @Mapping(target = "posAtendimentoPeso", source = "posAtendimento.peso")
    @Mapping(target = "posAtendimentoSupraUmbilical", source = "posAtendimento.supraUmbilical")
    @Mapping(target = "posAtendimentoLinhaUmbilical", source = "posAtendimento.linhaUmbilical")
    @Mapping(target = "posAtendimentoInfraUmbilical", source = "posAtendimento.infraUmbilical")
    @Mapping(target = "posAtendimentoOutrasMedidas", source = "posAtendimento.posAtendimentoOutrasMedidas")
    @Mapping(target = "posAtendimentoObservacao", source = "posAtendimento.observacao")
    @Mapping(target = "categoriaAtendimentoId", source = "categoriaAtendimento.id")
    @Mapping(target = "categoriaAtendimentoDescricao", source = "categoriaAtendimento.descricao")
    @Mapping(target = "tipoAtendimentoId", source = "tipoAtendimento.id")
    @Mapping(target = "tipoAtendimentoDescricao", source = "tipoAtendimento.descricao")
    AtendimentoDTO toDTO(Atendimento entity);

    @Mapping(source = "pacoteId", target = "pacote.id")
    @Mapping(source = "pacoteNumero", target = "pacote.numero")
    @Mapping(source = "pacoteValor", target = "pacote.valor")
    @Mapping(source = "pacoteTotalPago", target = "pacote.totalPago")
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "usuarioNomeCompleto", target = "usuario.nomeCompleto")
    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    @Mapping(source = "preAtendimentoId", target = "preAtendimento.id")
    @Mapping(source = "preAtendimentoData", target = "preAtendimento.data")
    @Mapping(source = "preAtendimentoPressaoArterial", target = "preAtendimento.pressaoArterial")
    @Mapping(source = "preAtendimentoPeso", target = "preAtendimento.peso")
    @Mapping(source = "preAtendimentoSupraUmbilical", target = "preAtendimento.supraUmbilical")
    @Mapping(source = "preAtendimentoLinhaUmbilical", target = "preAtendimento.linhaUmbilical")
    @Mapping(source = "preAtendimentoInfraUmbilical", target = "preAtendimento.infraUmbilical")
    @Mapping(source = "preAtendimentoOutrasMedidas", target = "preAtendimento.preAtendimentoOutrasMedidas")
    @Mapping(source = "preAtendimentoObservacao", target = "preAtendimento.observacao")
    @Mapping(source = "posAtendimentoId", target = "posAtendimento.id")
    @Mapping(source = "posAtendimentoData", target = "posAtendimento.data")
    @Mapping(source = "posAtendimentoPressaoArterial", target = "posAtendimento.pressaoArterial")
    @Mapping(source = "posAtendimentoPeso", target = "posAtendimento.peso")
    @Mapping(source = "posAtendimentoSupraUmbilical", target = "posAtendimento.supraUmbilical")
    @Mapping(source = "posAtendimentoLinhaUmbilical", target = "posAtendimento.linhaUmbilical")
    @Mapping(source = "posAtendimentoInfraUmbilical", target = "posAtendimento.infraUmbilical")
    @Mapping(source = "posAtendimentoOutrasMedidas", target = "posAtendimento.posAtendimentoOutrasMedidas")
    @Mapping(source = "posAtendimentoObservacao", target = "posAtendimento.observacao")
    @Mapping(source = "categoriaAtendimentoId", target = "categoriaAtendimento.id")
    @Mapping(source = "categoriaAtendimentoDescricao", target = "categoriaAtendimento.descricao")
    @Mapping(source = "tipoAtendimentoId", target = "tipoAtendimento.id")
    @Mapping(source = "tipoAtendimentoDescricao", target = "tipoAtendimento.descricao")
    Atendimento toEntity(AtendimentoDTO dto);

}
