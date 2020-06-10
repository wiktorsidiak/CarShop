package com.sidiak.CarShop.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LoginUserValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUserConstraint {
    String message() default "Invalid username or password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String login();
    String passwd();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        LoginUserConstraint[] value();
    }

}
