package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.CEP;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CEPValidator implements ConstraintValidator<CEP, String> {

    @Override
    public void initialize(CEP value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.length() == 8;
    }

}
