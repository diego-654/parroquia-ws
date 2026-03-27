package com.parroquias.parroquia_ws.parroquia_ws.common.validation;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsRequiredValidation implements ConstraintValidator<IsRequired, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        if (value instanceof String str) {
            return StringUtils.hasText(str);
        }
        return true; // cualquier otro tipo con valor distinto de null
    }
}
