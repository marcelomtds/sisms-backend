package br.com.sisms.api.model.mapper;

import br.com.sisms.api.model.dto.ContatoDTO;
import br.com.sisms.api.model.entity.Contato;
import org.mapstruct.Mapper;

@Mapper
public interface ContatoMapper extends BaseMapper<Contato, ContatoDTO> {
}
