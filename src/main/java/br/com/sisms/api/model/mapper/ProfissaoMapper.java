package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.ProfissaoDTO;
import br.com.sisms.api.model.entity.Profissao;

@Mapper
public interface ProfissaoMapper extends BaseMapper<Profissao, ProfissaoDTO> {

}
