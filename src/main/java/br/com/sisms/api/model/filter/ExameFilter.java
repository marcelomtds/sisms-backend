package br.com.sisms.api.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExameFilter {

    private Long pacienteId;
    private Long categoriaExameId;
    private LocalDate dataInicio;
    private LocalDate dataFim;

}
