package com.example.ui.annotation;

import com.example.ui.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Shpakova A.
 */

@Documented
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
    String message() default "This user name is used already. Please, choose another user name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
