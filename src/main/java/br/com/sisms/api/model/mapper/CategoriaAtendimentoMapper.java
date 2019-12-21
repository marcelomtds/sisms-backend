package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.CategoriaAtendimentoDTO;
import br.com.sisms.api.model.entity.CategoriaAtendimento;

@Mapper
public interface CategoriaAtendimentoMapper extends BaseMapper<CategoriaAtendimento, CategoriaAtendimentoDTO> {

}
