package com.example.ui.validator;

import com.example.ui.annotation.UniqueUsername;
import com.example.ui.service.UserService;
import lombok.RequiredArgsConstructor;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Shpakova A.
 */
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    @Override
    public void initialize(UniqueUsername username) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt) {
        return !userService.findByUserName(username);
    }
}
