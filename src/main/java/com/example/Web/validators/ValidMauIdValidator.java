package com.example.Web.validators;

import com.example.Web.entities.Mau;
import com.example.Web.validators.annotations.ValidMauId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidMauIdValidator implements
        ConstraintValidator<ValidMauId, Mau> {
    @Override
    public boolean isValid(Mau mau,
                           ConstraintValidatorContext context) {
        return mau != null && mau.getId() != null;
    }
}
