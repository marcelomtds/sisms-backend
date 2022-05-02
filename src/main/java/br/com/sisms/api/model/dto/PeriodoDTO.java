package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PeriodoDTO implements Serializable {

    private static final long serialVersionUID = -2743096279054838119L;

    private Long id;

    private String descricao;
}
