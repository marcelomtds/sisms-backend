package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PerfilDTO implements Serializable {

    private static final long serialVersionUID = 4473056957270031265L;

    private Long id;

    private String descricao;

    private String role;

}
