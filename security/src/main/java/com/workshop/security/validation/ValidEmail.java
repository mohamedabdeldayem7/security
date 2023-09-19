package com.workshop.security.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
    public String message() default "Invalid Email";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
