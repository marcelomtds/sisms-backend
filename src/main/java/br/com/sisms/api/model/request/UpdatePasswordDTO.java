package br.com.sisms.api.model.request;

import br.com.sisms.api.validation.constraint.Senha;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UpdatePasswordDTO implements Serializable {

    private static final long serialVersionUID = 1245639500763063184L;

    @NotBlank(message = "{senha.vazio}")
    @Senha(message = "{senha.tamanho}")
    private String senha;

    @NotBlank(message = "{senha.confirmacao.vazio}")
    @Senha(message = "{senha.confirmacao.tamanho}")
    private String senhaConfirmacao;

    @NotBlank(message = "{senha.atual.vazio}")
    @Size(max = 20, message = "{senha.atual.tamanho}")
    private String senhaAtual;

}
