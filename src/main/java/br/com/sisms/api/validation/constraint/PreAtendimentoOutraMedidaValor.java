package br.com.sisms.api.validation.constraint;

import br.com.sisms.api.validation.validator.PreAtendimentoOutraMedidaValorValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PreAtendimentoOutraMedidaValorValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface PreAtendimentoOutraMedidaValor {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}