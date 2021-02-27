package br.com.sisms.api.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AtendimentoFilter {

    private Long tipoAtendimentoId;
    private Long pacienteId;
    private Long usuarioId;
    private LocalDateTime preAtendimentoData;
    private LocalDateTime posAtendimentoData;
    private Boolean aberto;
    private Boolean lancamentoPendente;
    private Long categoriaAtendimentoId;

}
