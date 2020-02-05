package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.AnexoExameDTO;
import br.com.sisms.api.model.entity.AnexoExame;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ExameMapper.class})
public interface AnexoExameMapper extends BaseMapper<AnexoExame, AnexoExameDTO> {

    @Mapping(source = "exameId", target = "exame.id")
    AnexoExame toEntity(AnexoExameDTO dto);

    @Mapping(target = "exameId", source = "exame.id")
    AnexoExameDTO toDTO(AnexoExame entity);

}
