package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.Celular;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CelularValidator implements ConstraintValidator<Celular, String> {

    @Override
    public void initialize(Celular value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.length() == 11;
    }

}
