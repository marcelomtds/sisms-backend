package br.com.sisms.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoTotalDTO implements Serializable {

    private static final long serialVersionUID = -6109510519270550267L;

    private BigDecimal entrada;

    private BigDecimal saida;

    private BigDecimal total;

}
