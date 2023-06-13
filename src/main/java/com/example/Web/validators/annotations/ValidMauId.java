package com.example.Web.validators.annotations;

import com.example.Web.validators.ValidMauIdValidator;
import com.example.Web.validators.ValidNhomSPIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidMauIdValidator.class)
@Documented
public @interface ValidMauId {
    String message() default "Invalid Mau Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
