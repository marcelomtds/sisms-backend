package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.TipoAtendimentoDTO;
import br.com.sisms.api.model.entity.TipoAtendimento;
import org.mapstruct.Mapper;

@Mapper
public interface TipoAtendimentoMapper extends BaseMapper<TipoAtendimento, TipoAtendimentoDTO> {

}
