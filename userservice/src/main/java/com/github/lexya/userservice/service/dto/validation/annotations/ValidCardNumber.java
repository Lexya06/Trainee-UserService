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
@Size(min = 13, max = 19)
public @interface ValidCardNumber {
    String message() default "Card number min length is 13 and max length is 19";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
