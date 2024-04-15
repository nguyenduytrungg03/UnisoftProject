package com.example.projecttraining.dto.product_dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeesDTO implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    @Override
    public @NotNull Errors validateObject(@NotNull Object target) {
        return Validator.super.validateObject(target);
    }
}
