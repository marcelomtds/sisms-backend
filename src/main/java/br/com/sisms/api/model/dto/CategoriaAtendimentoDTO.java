package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaAtendimentoDTO implements Serializable {

    private static final long serialVersionUID = -8732174168656934282L;

    private Long id;
    private String descricao;

}
