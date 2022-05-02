package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ReservaDTO;
import br.com.sisms.api.model.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {PacienteMapper.class})
public interface ReservaMapper extends BaseMapper<Reserva, ReservaDTO> {

    @Mapping(source = "categoriaAtendimentoId", target = "categoriaAtendimento.id")
    @Mapping(source = "categoriaAtendimentoDescricao", target = "categoriaAtendimento.descricao")
    @Mapping(source = "diaSemanaId", target = "diaSemana.id")
    @Mapping(source = "diaSemanaDescricao", target = "diaSemana.descricao")
    @Mapping(source = "periodoId", target = "periodo.id")
    @Mapping(source = "periodoDescricao", target = "periodo.descricao")
    Reserva toEntity(ReservaDTO dto);

    @Mapping(target = "categoriaAtendimentoId", source = "categoriaAtendimento.id")
    @Mapping(target = "categoriaAtendimentoDescricao", source = "categoriaAtendimento.descricao")
    @Mapping(target = "diaSemanaId", source = "diaSemana.id")
    @Mapping(target = "diaSemanaDescricao", source = "diaSemana.descricao")
    @Mapping(target = "periodoId", source = "periodo.id")
    @Mapping(target = "periodoDescricao", source = "periodo.descricao")
    ReservaDTO toDTO(Reserva entity);
}
