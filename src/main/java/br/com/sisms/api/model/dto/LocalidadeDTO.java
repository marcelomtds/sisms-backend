package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LocalidadeDTO implements Serializable {

    private static final long serialVersionUID = -4979416283247902442L;

    private Long id;

    private String descricao;

    private UFDTO uf;

}
