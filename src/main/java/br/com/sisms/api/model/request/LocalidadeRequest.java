package br.com.sisms.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class LocalidadeRequest implements Serializable {

    private static final long serialVersionUID = -9153705312595930453L;

    private Long ig;

    @NotBlank(message = "{descricao.vazio}")
    @Size(max = 100, message = "{descricao.tamanho}")
    private String descricao;

    @NotNull(message = "{uf.vazio}")
    private Long ufId;
}
