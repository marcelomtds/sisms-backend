package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TipoLancamentoDTO implements Serializable {

    private static final long serialVersionUID = -8114527708715907008L;

    private Long id;

    private String descricao;

}
