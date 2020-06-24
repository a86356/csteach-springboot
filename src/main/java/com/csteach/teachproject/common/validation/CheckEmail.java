package com.csteach.teachproject.common.validation;

import com.csteach.teachproject.common.validation.validator.CheckEmailConstraintValidator;
import com.csteach.teachproject.common.validation.validator.CheckPhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailConstraintValidator.class)
public @interface CheckEmail {

    String message() default "邮箱格式错误";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
