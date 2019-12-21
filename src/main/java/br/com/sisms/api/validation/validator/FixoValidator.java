package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.Fixo;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FixoValidator implements ConstraintValidator<Fixo, String> {

    @Override
    public void initialize(Fixo value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.length() == 10;
    }

}
