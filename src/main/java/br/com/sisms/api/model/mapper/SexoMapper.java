package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.SexoDTO;
import br.com.sisms.api.model.entity.Sexo;

@Mapper
public interface SexoMapper extends BaseMapper<Sexo, SexoDTO> {

}
