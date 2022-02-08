package br.com.sisms.api.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class LancamentoFilter {

    private Long atendimentoId;
    private Long pacoteId;
    private Long categoriaAtendimentoId;
    private Long formaPagamentoId;
    private List<Long> tipoLancamentoIds;
    private Long tipoAtendimentoId;
    private Long pacienteId;
    private Long usuarioId;
    private Long categoriaLancamentoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
