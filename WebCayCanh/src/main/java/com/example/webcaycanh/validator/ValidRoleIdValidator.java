package com.example.webcaycanh.validator;


import com.example.webcaycanh.entity.Role;
import com.example.webcaycanh.validator.annotation.ValidRoleId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class ValidRoleIdValidator implements ConstraintValidator<ValidRoleId, Role>{
    @Override
    public boolean isValid(Role role, ConstraintValidatorContext context){
        return role != null && role.getId() != null;
    }
}
