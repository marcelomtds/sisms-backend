package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PreAtendimentoDTO;
import br.com.sisms.api.model.entity.PreAtendimento;
import org.mapstruct.Mapper;

@Mapper(uses = {PreAtendimentoOutraMedidaMapper.class})
public interface PreAtendimentoMapper extends BaseMapper<PreAtendimento, PreAtendimentoDTO> {
}
