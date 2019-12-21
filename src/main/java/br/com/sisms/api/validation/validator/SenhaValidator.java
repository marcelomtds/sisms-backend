package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.Senha;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SenhaValidator implements ConstraintValidator<Senha, String> {

    @Override
    public void initialize(Senha value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.length() >= 6 && value.length() <= 20;
    }

}
