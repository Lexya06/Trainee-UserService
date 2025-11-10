package com.github.lexya.userservice.service.dto.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Size(max = 300)
@Constraint(validatedBy = {})
public @interface ValidCardHolder {
    String message() default "Card holder max length is 300";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
