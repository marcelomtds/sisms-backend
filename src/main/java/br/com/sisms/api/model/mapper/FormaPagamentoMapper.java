package br.com.sisms.api.model.mapper;

import org.mapstruct.Mapper;

import br.com.sisms.api.model.dto.FormaPagamentoDTO;
import br.com.sisms.api.model.entity.FormaPagamento;

@Mapper
public interface FormaPagamentoMapper extends BaseMapper<FormaPagamento, FormaPagamentoDTO> {

}
