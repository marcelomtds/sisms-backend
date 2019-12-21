package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PreAtendimentoOutraMedidaDTO implements Serializable {

    private static final long serialVersionUID = -6561039583770901500L;

    private Long id;

    private Long preAtendimentoId;

    @NotNull(message = "{pre.atendimento.outra.medida.descricao}")
    private Long outraMedidaId;

    private String outraMedidaDescricao;

    @NotNull(message = "{pre.atendimento.outra.medida.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{pre.atendimento.outra.medida.valor}")
    @DecimalMax(value = "999.9", message = "{pre.atendimento.outra.medida.valor}")
    private BigDecimal valor;

}
