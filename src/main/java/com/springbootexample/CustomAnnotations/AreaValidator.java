package com.springbootexample.CustomAnnotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AreaValidator implements ConstraintValidator<MyArea, Object> {
    private static final String AREA = "Sector-16";

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == AREA)
            return true;
        return false;
    }
}
