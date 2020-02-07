package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ReservaDTO;
import br.com.sisms.api.model.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {PacienteMapper.class})
public interface ReservaMapper extends BaseMapper<Reserva, ReservaDTO> {

    @Mapping(target = "pacienteId", source = "paciente.id")
    @Mapping(target = "pacienteNomeCompleto", source = "paciente.nomeCompleto")
    ReservaDTO toDTO(Reserva entity);

    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "pacienteNomeCompleto", target = "paciente.nomeCompleto")
    Reserva toEntity(ReservaDTO dto);

}
