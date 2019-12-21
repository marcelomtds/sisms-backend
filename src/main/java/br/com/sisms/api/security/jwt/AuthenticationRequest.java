package br.com.sisms.api.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationRequest {

    @NotBlank(message = "{cpf.vazio}")
    @Size(min = 11, max = 11, message = "{cpf.tamanho}")
    private String cpf;

    @NotBlank(message = "{senha.vazio}")
    @Size(max = 20, message = "{senha.tamanho}")
    private String senha;

}
