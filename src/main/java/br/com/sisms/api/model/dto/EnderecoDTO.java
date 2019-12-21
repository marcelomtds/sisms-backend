package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = -7466010912430096369L;

    private Long id;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String pontoReferencia;

    private LocalidadeDTO localidade;


}
