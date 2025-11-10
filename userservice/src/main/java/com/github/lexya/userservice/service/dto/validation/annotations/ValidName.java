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
@Constraint(validatedBy = {})
@Size(max = 100)
public @interface ValidName {
    String message() default  "Name max length is 100";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
