package br.com.sisms.api.security.jwt;

import br.com.sisms.api.validation.constraint.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class AutenticacaoDTO {

    @NotBlank(message = "{cpf.vazio}")
    @CPF(message = "{cpf.invalido}")
    private String cpf;

    @NotBlank(message = "{senha.vazio}")
    @Size(max = 20, message = "{senha.tamanho}")
    private String senha;

}
