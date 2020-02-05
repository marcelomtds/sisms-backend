package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class AnexoExameDTO implements Serializable {

    private static final long serialVersionUID = -899576870370134688L;

    private Long id;

    private Long exameId;

    @NotBlank(message = "{anexo.nome.vazio}")
    @Size(max = 200, message = "{anexo.nome.tamanho}")
    private String nome;

    @NotBlank(message = "{anexo.anexo}")
    @Size(max = 10485760, message = "{anexo.tamanho}")
    private String anexo;

    @Size(max = 200, message = "{anexo.observacao}")
    private String observacao;

}
