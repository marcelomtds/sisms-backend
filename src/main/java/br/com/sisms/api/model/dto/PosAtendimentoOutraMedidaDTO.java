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
public class PosAtendimentoOutraMedidaDTO implements Serializable {

    private static final long serialVersionUID = 7424187562554072284L;

    private Long id;

    private Long posAtendimentoId;

    @NotNull(message = "{pos.atendimento.outra.medida.descricao}")
    private Long outraMedidaId;

    private String outraMedidaDescricao;

    @NotNull(message = "{pos.atendimento.outra.medida.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{pos.atendimento.outra.medida.valor}")
    @DecimalMax(value = "999.9", message = "{pos.atendimento.outra.medida.valor}")
    private BigDecimal valor;

}
