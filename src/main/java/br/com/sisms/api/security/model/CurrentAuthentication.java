package br.com.sisms.api.security.model;

import br.com.sisms.api.model.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CurrentAuthentication {

    private String token;
    private UsuarioDTO usuario;

}
