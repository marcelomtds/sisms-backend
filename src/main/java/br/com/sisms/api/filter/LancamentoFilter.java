package br.com.sisms.api.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LancamentoFilter {

    private Long atendimentoId;
    private Long pacoteId;
    private Long categoriaAtendimentoId;
    private Long formaPagamentoId;
    private Long tipoLancamentoId;
    private Long tipoAtendimentoId;
    private Long pacienteId;
    private Long usuarioId;
    private Long categoriaLancamentoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;

}
