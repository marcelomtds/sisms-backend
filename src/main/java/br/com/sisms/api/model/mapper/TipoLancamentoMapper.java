package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.TipoLancamentoDTO;
import br.com.sisms.api.model.entity.TipoLancamento;
import org.mapstruct.Mapper;

@Mapper
public interface TipoLancamentoMapper extends BaseMapper<TipoLancamento, TipoLancamentoDTO> {

}
