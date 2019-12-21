package br.com.sisms.api.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

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
