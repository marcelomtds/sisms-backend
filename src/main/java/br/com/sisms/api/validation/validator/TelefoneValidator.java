package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.Telefone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

    @Override
    public void initialize(Telefone value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        return value.length() == 10 || value.length() == 11;
    }

}
