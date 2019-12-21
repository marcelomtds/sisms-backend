package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.EnderecoDTO;
import br.com.sisms.api.model.entity.Endereco;
import org.mapstruct.Mapper;

@Mapper(uses = {LocalidadeMapper.class})
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {
}
