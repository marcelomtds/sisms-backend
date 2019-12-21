package br.com.sisms.api.model.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoRequest implements Serializable {

    private static final long serialVersionUID = 9194614129742492001L;

    private Long id;

    private Long atendimentoId;

    private Long pacoteId;

    private Long categoriaLancamentoId;

    @NotNull(message = "{forma.pagamento.vazio}")
    private Long formaPagamentoId;

    @NotNull(message = "{lancamento.data.vazio}")
    private LocalDate data;

    @NotNull(message = "{valor.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{valor.tamanho}")
    @DecimalMax(value = "999999.99", message = "{valor.tamanho}")
    private BigDecimal valor;

    @Size(max = 200, message = "{lancamento.observacao.tamanho}")
    private String observacao;

}
