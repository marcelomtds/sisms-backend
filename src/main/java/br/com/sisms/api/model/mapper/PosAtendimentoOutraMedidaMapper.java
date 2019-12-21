package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PosAtendimentoOutraMedidaDTO;
import br.com.sisms.api.model.entity.PosAtendimentoOutraMedida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {OutraMedidaMapper.class, PosAtendimentoMapper.class})
public interface PosAtendimentoOutraMedidaMapper extends BaseMapper<PosAtendimentoOutraMedida, PosAtendimentoOutraMedidaDTO> {

    @Mapping(source = "posAtendimento.id", target = "posAtendimentoId")
    @Mapping(source = "outraMedida.id", target = "outraMedidaId")
    @Mapping(source = "outraMedida.descricao", target = "outraMedidaDescricao")
    PosAtendimentoOutraMedidaDTO toDTO(PosAtendimentoOutraMedida entity);

    @Mapping(target = "posAtendimento.id", source = "posAtendimentoId")
    @Mapping(target = "outraMedida.id", source = "outraMedidaId")
    @Mapping(target = "outraMedida.descricao", source = "outraMedidaDescricao")
    PosAtendimentoOutraMedida toEntity(PosAtendimentoOutraMedidaDTO dto);

}
