package com.example.studentresultmanagementsystem.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Past;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = { DateOfBirthValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Past
@ReportAsSingleViolation
public @interface DateOfBirth {
    String message() default "Invalid date of birth";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}