package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.LocalidadeDTO;
import br.com.sisms.api.model.entity.Localidade;
import br.com.sisms.api.model.request.LocalidadeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UFMapper.class})
public interface LocalidadeMapper extends BaseMapper<Localidade, LocalidadeDTO> {

    @Mapping(source = "ufId", target = "uf.id")
    LocalidadeDTO toDTO(LocalidadeRequest request);

    @Mapping(source = "ufId", target = "uf.id")
    Localidade toEntity(LocalidadeRequest request);

}
