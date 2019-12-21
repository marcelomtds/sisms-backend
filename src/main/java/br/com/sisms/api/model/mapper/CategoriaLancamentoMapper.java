package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.CategoriaLancamentoDTO;
import br.com.sisms.api.model.entity.CategoriaLancamento;

@Mapper
public interface CategoriaLancamentoMapper extends BaseMapper<CategoriaLancamento, CategoriaLancamentoDTO> {

}
