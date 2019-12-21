package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.OutraMedidaDTO;
import br.com.sisms.api.model.entity.OutraMedida;
import org.mapstruct.Mapper;

@Mapper
public interface OutraMedidaMapper extends BaseMapper<OutraMedida, OutraMedidaDTO> {
}
