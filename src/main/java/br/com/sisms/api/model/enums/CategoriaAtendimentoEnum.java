package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoriaAtendimentoEnum {

    DRENAGEM_LINFATICA(1L),
    FISIOTERAPIA(2L),
    RPG(3L),
    PILATES(4L),
    MASSAGEM_RELAXANTE(5L);

    private Long categoriaAtendimento;

    public Long getTipoAtendimento() {
        return categoriaAtendimento;
    }

}
