package com.sidiak.CarShop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sidiak.CarShop.model.User;
import com.sidiak.CarShop.service.UserServiсe;


public class LoginUserValidator implements ConstraintValidator<LoginUserConstraint, String> {
    private UserServiсe userServiсe;

    private String loginFieldName;
    private String passwordFieldName;

    @Override
    public void initialize(LoginUserConstraint loginUserConstraint) {
        loginFieldName = loginUserConstraint.login();
        passwordFieldName = loginUserConstraint.passwd();

    }

    @Override
    public boolean isValid(String loginField, ConstraintValidatorContext constraintValidatorContext) {
    return
    }
}
