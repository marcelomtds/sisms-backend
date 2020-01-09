package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.AgendaDTO;
import br.com.sisms.api.model.entity.Agenda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AgendaMapper extends BaseMapper<Agenda, AgendaDTO> {

    @Mapping(target = "diaSemanaId", source = "diaSemana.id")
    @Mapping(target = "diaSemanaDescricao", source = "diaSemana.descricao")
    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    @Mapping(target = "tipoAtendimentoId", source = "tipoAtendimento.id")
    @Mapping(target = "tipoAtendimentoDescricao", source = "tipoAtendimento.descricao")
    @Mapping(target = "categoriaAtendimentoId", source = "categoriaAtendimento.id")
    @Mapping(target = "categoriaAtendimentoDescricao", source = "categoriaAtendimento.descricao")
    AgendaDTO toDTO(Agenda entity);

    @Mapping(source = "diaSemanaId", target = "diaSemana.id")
    @Mapping(source = "diaSemanaDescricao", target = "diaSemana.descricao")
    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    @Mapping(source = "tipoAtendimentoId", target = "tipoAtendimento.id")
    @Mapping(source = "tipoAtendimentoDescricao", target = "tipoAtendimento.descricao")
    @Mapping(source = "categoriaAtendimentoId", target = "categoriaAtendimento.id")
    @Mapping(source = "categoriaAtendimentoDescricao", target = "categoriaAtendimento.descricao")
    Agenda toEntity(AgendaDTO dto);

}
