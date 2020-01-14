package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class CategoriaExameDTO implements Serializable {

    private static final long serialVersionUID = 4308380929444935115L;

    private Long id;

    @NotBlank(message = "{descricao.vazio}")
    @Size(max = 100, message = "{descricao.tamanho}")
    private String descricao;

}
