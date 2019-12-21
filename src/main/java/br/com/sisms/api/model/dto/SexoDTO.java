package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SexoDTO implements Serializable {

    private static final long serialVersionUID = -6737405805233627501L;

    private Long id;

    private String descricao;

}
