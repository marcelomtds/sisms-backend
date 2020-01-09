package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.DiaSemanaDTO;
import br.com.sisms.api.model.entity.DiaSemana;
import org.mapstruct.Mapper;

@Mapper
public interface DiaSemanaMapper extends BaseMapper<DiaSemana, DiaSemanaDTO> {

}
