package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
public class AgendaDTO implements Serializable {

    private static final long serialVersionUID = -831363491514555752L;

    private Long id;

    @NotNull(message = "{dia.semana.vazio}")
    private Long diaSemanaId;

    private String diaSemanaDescricao;

    @NotNull(message = "{horario.inicio.vazio}")
    private LocalTime horarioInicio;

    @NotNull(message = "{horario.fim.vazio}")
    private LocalTime horarioFim;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    private String pacienteNomeCompleto;

    @NotNull(message = "{tipo.atendimento.vazio}")
    private Long tipoAtendimentoId;

    private String tipoAtendimentoDescricao;

    @NotNull(message = "{categoria.atendimento.vazio}")
    private Long categoriaAtendimentoId;

    private String categoriaAtendimentoDescricao;

}