package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.PreAtendimentoOutraMedidaDTO;
import br.com.sisms.api.model.entity.PreAtendimentoOutraMedida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {OutraMedidaMapper.class, PreAtendimentoMapper.class})
public interface PreAtendimentoOutraMedidaMapper extends BaseMapper<PreAtendimentoOutraMedida, PreAtendimentoOutraMedidaDTO> {

    @Mapping(source = "preAtendimento.id", target = "preAtendimentoId")
    @Mapping(source = "outraMedida.id", target = "outraMedidaId")
    @Mapping(source = "outraMedida.descricao", target = "outraMedidaDescricao")
    PreAtendimentoOutraMedidaDTO toDTO(PreAtendimentoOutraMedida entity);

    @Mapping(target = "preAtendimento.id", source = "preAtendimentoId")
    @Mapping(target = "outraMedida.id", source = "outraMedidaId")
    @Mapping(target = "outraMedida.descricao", source = "outraMedidaDescricao")
    PreAtendimentoOutraMedida toEntity(PreAtendimentoOutraMedidaDTO dto);

}
