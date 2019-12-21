package br.com.sisms.api.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoLancamentoEnum {

    ENTRADA(1L),
    SAIDA(2L);

    private Long tipoLancamento;

    public Long getTipoLancamento() {
        return tipoLancamento;
    }

}
