package br.com.sisms.api.validation.validator;

import br.com.sisms.api.model.dto.PreAtendimentoOutraMedidaDTO;
import br.com.sisms.api.validation.constraint.PreAtendimentoOutraMedidaDescricao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PreAtendimentoOutraMedidaDescricaoValidator implements ConstraintValidator<PreAtendimentoOutraMedidaDescricao, List<PreAtendimentoOutraMedidaDTO>> {

    @Override
    public void initialize(PreAtendimentoOutraMedidaDescricao value) {
    }

    @Override
    public boolean isValid(List<PreAtendimentoOutraMedidaDTO> list, ConstraintValidatorContext cxt) {
        if (!list.isEmpty()) {
            for (PreAtendimentoOutraMedidaDTO item : list) {
                if (java.util.Objects.isNull(item.getOutraMedidaId())) {
                    return false;
                }
            }
        }
        return true;
    }

}
