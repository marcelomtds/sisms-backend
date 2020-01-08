package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum {

    ADMINISTRADOR("ADMINISTRADOR"),
    USUARIO("USUARIO");

    private String role;

    public String getPerfil() {
        return role;
    }

}
