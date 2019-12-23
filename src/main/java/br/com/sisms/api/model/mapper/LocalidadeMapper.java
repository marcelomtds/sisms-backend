package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.LocalidadeDTO;
import br.com.sisms.api.model.entity.Localidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UFMapper.class})
public interface LocalidadeMapper extends BaseMapper<Localidade, LocalidadeDTO> {

    @Mapping(source = "ufId", target = "uf.id")
    @Mapping(source = "ufDescricao", target = "uf.descricao")
    Localidade toEntity(LocalidadeDTO dto);

    @Mapping(target = "ufId", source = "uf.id")
    @Mapping(target = "ufDescricao", source = "uf.descricao")
    LocalidadeDTO toDTO(Localidade entity);

}
