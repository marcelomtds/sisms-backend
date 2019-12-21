package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UFDTO implements Serializable {

    private static final long serialVersionUID = -8026450637369763562L;

    private Long id;

    @NotBlank(message = "{descricao.vazio}")
    @Size(max = 100, message = "{descricao.tamanho}")
    private String descricao;

}
