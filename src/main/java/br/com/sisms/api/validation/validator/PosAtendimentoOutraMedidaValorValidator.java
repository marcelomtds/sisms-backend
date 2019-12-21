package br.com.sisms.api.validation.validator;

import br.com.sisms.api.model.dto.PosAtendimentoOutraMedidaDTO;
import br.com.sisms.api.validation.constraint.PosAtendimentoOutraMedidaValor;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class PosAtendimentoOutraMedidaValorValidator implements ConstraintValidator<PosAtendimentoOutraMedidaValor, List<PosAtendimentoOutraMedidaDTO>> {

    private static final double MIN_VALUE = 0.1;
    private static final double MAX_VALUE = 999.9;

    @Override
    public void initialize(PosAtendimentoOutraMedidaValor value) {
    }

    @Override
    public boolean isValid(List<PosAtendimentoOutraMedidaDTO> list, ConstraintValidatorContext cxt) {
        if (!ObjectUtils.isEmpty(list.isEmpty())) {
            for (PosAtendimentoOutraMedidaDTO item : list) {
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
