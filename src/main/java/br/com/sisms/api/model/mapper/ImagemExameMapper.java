package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ImagemExameDTO;
import br.com.sisms.api.model.entity.ImagemExame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ExameMapper.class})
public interface ImagemExameMapper extends BaseMapper<ImagemExame, ImagemExameDTO> {

    @Mapping(source = "exameId", target = "exame.id")
    ImagemExame toEntity(ImagemExameDTO dto);

    @Mapping(target = "exameId", source = "exame.id")
    ImagemExameDTO toDTO(ImagemExame entity);

}
