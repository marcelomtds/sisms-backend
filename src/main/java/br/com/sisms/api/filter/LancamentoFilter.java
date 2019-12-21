package br.com.sisms.api.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LancamentoFilter {

    private Long atendimentoId;
    private Long pacoteId;
    private String tipoLancamento;
    private String tipoAtendimento;
    private Long categoriaAtendimentoId;
    private Long pacienteId;
    private Long formaPagamentoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;

}
