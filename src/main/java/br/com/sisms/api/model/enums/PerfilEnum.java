package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PerfilEnum {

    ADMINISTRADOR(1L),
    USUARIO(2L);

    private Long perfil;

    public Long getPerfil() {
        return perfil;
    }

}
