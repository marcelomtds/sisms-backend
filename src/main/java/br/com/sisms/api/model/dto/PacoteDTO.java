package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PacoteDTO implements Serializable {

    private static final long serialVersionUID = -6912134959613802722L;

    private Long id;

    private LocalDate dataCriacao;

    @NotNull(message = "{valor.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{valor.tamanho}")
    @DecimalMax(value = "999999.99", message = "{valor.tamanho}")
    private BigDecimal valor;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    private String pacienteNomeCompleto;

    private Long usuarioId;

    private String usuarioNomeCompleto;

    @NotNull(message = "{categoria.atendimento.vazio}")
    private Long categoriaAtendimentoId;

    private String categoriaAtendimentoDescricao;

    private Long numero;

    private Boolean aberto;

    private Long quantidadeAtendimentos;

    private BigDecimal totalPago;

}