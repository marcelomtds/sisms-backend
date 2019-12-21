package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ImagemAtendimentoDTO;
import br.com.sisms.api.model.entity.ImagemAtendimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AtendimentoMapper.class})
public interface ImagemAtendimentoMapper extends BaseMapper<ImagemAtendimento, ImagemAtendimentoDTO> {

    @Mapping(source = "atendimento.id", target = "atendimentoId")
    ImagemAtendimentoDTO toDTO(ImagemAtendimento entity);

    @Mapping(target = "atendimento.id", source = "atendimentoId")
    ImagemAtendimento toEntity(ImagemAtendimentoDTO dto);

}
