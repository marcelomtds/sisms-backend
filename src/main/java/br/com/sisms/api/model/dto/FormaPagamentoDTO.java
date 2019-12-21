package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FormaPagamentoDTO implements Serializable {

    private static final long serialVersionUID = -2736499525801283057L;

    private Long id;
    private String descricao;

}
