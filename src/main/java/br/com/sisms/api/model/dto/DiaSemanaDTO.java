package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DiaSemanaDTO implements Serializable {

    private static final long serialVersionUID = -749595300989339243L;

    private Long id;

    private String descricao;

}
