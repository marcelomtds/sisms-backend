package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PosAtendimentoDTO;
import br.com.sisms.api.model.entity.PosAtendimento;
import br.com.sisms.api.repository.PosAtendimentoOutraMedidaRepository;
import org.mapstruct.Mapper;

@Mapper(uses = {PosAtendimentoOutraMedidaMapper.class})
public interface PosAtendimentoMapper extends BaseMapper<PosAtendimento, PosAtendimentoDTO> {
}
