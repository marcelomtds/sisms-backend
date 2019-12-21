package br.com.sisms.api.validation.validator;

import br.com.sisms.api.model.dto.PosAtendimentoOutraMedidaDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PosAtendimentoOutraMedidaDescricaoValidator implements ConstraintValidator<br.com.sisms.api.validation.constraint.PosAtendimentoOutraMedidaDescricao, List<PosAtendimentoOutraMedidaDTO>> {

    @Override
    public void initialize(br.com.sisms.api.validation.constraint.PosAtendimentoOutraMedidaDescricao value) {
    }

    @Override
    public boolean isValid(List<PosAtendimentoOutraMedidaDTO> list, ConstraintValidatorContext cxt) {
        if (!list.isEmpty()) {
            for (PosAtendimentoOutraMedidaDTO item : list) {
                if (java.util.Objects.isNull(item.getOutraMedidaId())) {
                    return false;
                }
            }
        }
        return true;
    }

}
