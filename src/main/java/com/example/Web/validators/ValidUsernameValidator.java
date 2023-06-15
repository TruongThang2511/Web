package com.example.Web.validators;

import com.example.Web.services.UserService;
import com.example.Web.validators.annotations.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername,String> {
    private final UserService userService;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(userService.findByUsername(username).isEmpty())
            return false;
        else
            return true;
    }
}
