package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.UFDTO;
import br.com.sisms.api.model.entity.UF;
import org.mapstruct.Mapper;

@Mapper
public interface UFMapper extends BaseMapper<UF, UFDTO> {
}
