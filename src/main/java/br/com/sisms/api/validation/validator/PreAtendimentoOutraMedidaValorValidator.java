package br.com.sisms.api.validation.validator;

import br.com.sisms.api.model.dto.PreAtendimentoOutraMedidaDTO;
import br.com.sisms.api.validation.constraint.PreAtendimentoOutraMedidaValor;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class PreAtendimentoOutraMedidaValorValidator implements ConstraintValidator<PreAtendimentoOutraMedidaValor, List<PreAtendimentoOutraMedidaDTO>> {

    private static final double MIN_VALUE = 0.1;
    private static final double MAX_VALUE = 999.9;

    @Override
    public void initialize(PreAtendimentoOutraMedidaValor value) {
    }

    @Override
    public boolean isValid(List<PreAtendimentoOutraMedidaDTO> list, ConstraintValidatorContext cxt) {
        if (!ObjectUtils.isEmpty(list.isEmpty())) {
            for (PreAtendimentoOutraMedidaDTO item : list) {
                if (Objects.isNull(item.getValor())
                        || new BigDecimal(item.getValor().doubleValue()).compareTo(new BigDecimal(MIN_VALUE)) == -1
                        || new BigDecimal(item.getValor().doubleValue()).compareTo(new BigDecimal(MAX_VALUE)) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
