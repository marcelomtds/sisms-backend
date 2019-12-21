package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoAtendimentoEnum {

    SESSAO(1L),
    PACOTE(2L);

    private Long perfil;

    public Long getTipoAtendimento() {
        return perfil;
    }

}
