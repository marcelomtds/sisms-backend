package br.com.sisms.api.validation.validator;

import br.com.sisms.api.validation.constraint.PressaoArterial;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PressaoArterialValidator implements ConstraintValidator<PressaoArterial, String> {

    @Override
    public void initialize(PressaoArterial value) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        final Pattern pattern = Pattern.compile("^[0-9]{3}\\/[0-9]{3}$");
        return pattern.matcher(value).matches();
    }

}
