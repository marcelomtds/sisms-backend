package br.com.sisms.api.model.dto;

import br.com.sisms.api.validation.constraint.CPF;
import br.com.sisms.api.validation.constraint.Senha;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class PreCadastroUsuarioDTO implements Serializable {

    private static final long serialVersionUID = -2303885982845957151L;

    @NotBlank(message = "{cpf.vazio}")
    @CPF(message = "{cpf.invalido}")
    private String cpf;

    @Senha(message = "{senha.atual.tamanho}")
    @NotBlank(message = "{senha.atual.vazio}")
    @Size(max = 20, message = "{senha.atual.tamanho}")
    private String senha;

    @Senha(message = "{senha.atual.confirmacao.tamanho}")
    @NotBlank(message = "{senha.atual.confirmacao.vazio}")
    @Size(max = 20, message = "{senha.atual.confirmacao.tamanho}")
    private String senhaConfirmacao;

}
