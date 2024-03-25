package com.example.studentresultmanagementsystem.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirth, LocalDate> {

    @Override
    public void initialize(DateOfBirth constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        return dateOfBirth != null && dateOfBirth.isBefore(LocalDate.now().minusYears(10));
    }
}
