package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.MenuDTO;
import br.com.sisms.api.model.entity.Menu;
import org.mapstruct.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {

}
