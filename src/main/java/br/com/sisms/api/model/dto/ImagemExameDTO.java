package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class ImagemExameDTO implements Serializable {

    private static final long serialVersionUID = -899576870370134688L;

    private Long id;

    private Long exameId;

    @Size(max = 10485760, message = "{imagem.tamanho}")
    private String imagem;

    @Size(max = 200, message = "{imagem.observacao}")
    private String observacao;

}