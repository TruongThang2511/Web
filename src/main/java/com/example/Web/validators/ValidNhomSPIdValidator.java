package com.example.Web.validators;

import com.example.Web.entities.NhomSanPham;
import com.example.Web.validators.annotations.ValidNhomSPId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNhomSPIdValidator implements
        ConstraintValidator<ValidNhomSPId, NhomSanPham> {
    @Override
    public boolean isValid(NhomSanPham nhomsanpham,
                           ConstraintValidatorContext context) {
        return nhomsanpham != null && nhomsanpham.getId() != null;
    }
}
