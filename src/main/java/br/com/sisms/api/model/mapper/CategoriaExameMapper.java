package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.CategoriaExameDTO;
import br.com.sisms.api.model.entity.CategoriaExame;
import org.mapstruct.Mapper;

@Mapper
public interface CategoriaExameMapper extends BaseMapper<CategoriaExame, CategoriaExameDTO> {

}
