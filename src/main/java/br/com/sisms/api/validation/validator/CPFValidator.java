package br.com.sisms.api.validation.validator;

import br.com.sisms.api.util.Util;
import br.com.sisms.api.validation.constraint.CPF;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPF, String> {

    @Override
    public void initialize(CPF value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return Util.isValidCpf(value);
    }

}
