package com.example.Web.validators;

import com.example.Web.entities.DanhMuc;
import com.example.Web.validators.annotations.ValidDanhMucId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDanhMucIdValidator implements
        ConstraintValidator<ValidDanhMucId, DanhMuc> {
    @Override
    public boolean isValid(DanhMuc danhmuc,
                           ConstraintValidatorContext context) {
        return danhmuc != null && danhmuc.getId() != null;
    }
}
