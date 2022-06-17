package com.fmi.MovieRating.validator;

import com.fmi.MovieRating.dtos.RegistrationRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationRequest> {

    @Override
    public boolean isValid(final RegistrationRequest registrationRequest, final ConstraintValidatorContext context) {
        return registrationRequest.getPassword().equals(registrationRequest.getMatchingPassword());
    }

}
