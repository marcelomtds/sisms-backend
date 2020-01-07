package br.com.sisms.api.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacoteFilter {

    private Long categoriaAtendimentoId;
    private Long pacienteId;
    private Long usuarioId;
    private Boolean aberto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

}
