package com.example.Web.validators.annotations;

import com.example.Web.validators.ValidDanhMucIdValidator;
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
@Constraint(validatedBy = ValidDanhMucIdValidator.class)
@Documented
public @interface ValidDanhMucId {
    String message() default "Invalid Danh Muc Id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
