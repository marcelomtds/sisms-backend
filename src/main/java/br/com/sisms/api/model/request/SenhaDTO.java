package br.com.sisms.api.model.request;

import br.com.sisms.api.validation.constraint.Senha;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class SenhaDTO implements Serializable {

    private static final long serialVersionUID = 1245639500763063184L;

    @NotBlank(message = "{senha.atual.vazio}")
    @Size(max = 20, message = "{senha.atual.tamanho}")
    private String senhaAtual;

    @NotBlank(message = "{nova.senha.vazio}")
    @Senha(message = "{nova.senha.tamanho}")
    private String novaSenha;

    @NotBlank(message = "{nova.senha.confirmacao.vazio}")
    @Senha(message = "{nova.senha.confirmacao.tamanho}")
    private String novaSenhaConfirmacao;


}
