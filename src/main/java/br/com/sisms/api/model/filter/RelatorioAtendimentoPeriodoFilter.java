package br.com.sisms.api.model.filter;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RelatorioAtendimentoPeriodoFilter {

    @NotNull(message = "{relatorio.data.inicio.vazio}")
    private LocalDate dataInicio;

    @NotNull(message = "{relatorio.data.fim.vazio}")
    private LocalDate dataFim;

    private Boolean agruparPorMes;

    private List<Long> categoriasAtendimentoId;
}
