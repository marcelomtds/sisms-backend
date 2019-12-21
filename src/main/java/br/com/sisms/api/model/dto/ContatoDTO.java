package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContatoDTO implements Serializable {

    private static final long serialVersionUID = -8273200875502072499L;

    private Long id;

    private String celular;

    private String celularRecado;

    private String residencial;

    private String comercial;

    private String email;

}
