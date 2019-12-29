package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoDTO implements Serializable {

    private static final long serialVersionUID = 1399706395171864005L;

    private Long id;

    @NotNull(message = "{lancamento.data.vazio}")
    private LocalDate data;

    @NotNull(message = "{valor.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{valor.tamanho}")
    @DecimalMax(value = "999999.99", message = "{valor.tamanho}")
    private BigDecimal valor;

    @Column(length = 200)
    private String observacao;

    private Long usuarioId;

    private String usuarioNomeCompleto;

    private Long atendimentoId;

    private String atendimentoPacienteNomeCompleto;

    private String pacotePacienteNomeCompleto;

    private Long pacoteId;

    private Long categoriaLancamentoId;

    private String categoriaLancamentoDescricao;

    @NotNull(message = "{forma.pagamento.vazio}")
    private Long formaPagamentoId;

    private String formaPagamentoDescricao;

    private Long tipoLancamentoId;

    private String tipoLancamentoDescricao;

    private Long tipoAtendimentoId;

    private String tipoAtendimentoDescricao;

    private String atendimentoCategoriaAtendimentoDescricao;

    private String pacoteCategoriaAtendimentoDescricao;

}