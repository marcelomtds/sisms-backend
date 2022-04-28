package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PeriodoDTO;
import br.com.sisms.api.model.entity.Periodo;
import org.mapstruct.Mapper;

@Mapper
public interface PeriodoMapper extends BaseMapper<Periodo, PeriodoDTO> {

}
