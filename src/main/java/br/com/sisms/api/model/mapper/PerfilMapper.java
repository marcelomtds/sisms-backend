package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.PerfilDTO;
import br.com.sisms.api.model.entity.Perfil;

@Mapper
public interface PerfilMapper extends BaseMapper<Perfil, PerfilDTO> {

}
