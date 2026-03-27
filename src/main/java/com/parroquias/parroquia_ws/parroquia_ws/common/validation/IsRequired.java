package com.parroquias.parroquia_ws.parroquia_ws.common.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IsRequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })

public @interface IsRequired {
    String message() default "El campo es obligatorio";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
