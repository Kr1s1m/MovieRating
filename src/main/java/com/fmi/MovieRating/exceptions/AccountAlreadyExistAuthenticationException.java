package com.fmi.MovieRating.exceptions;

import org.springframework.security.core.AuthenticationException;


public class AccountAlreadyExistAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 5570981880007077317L;

    public AccountAlreadyExistAuthenticationException(final String msg) {
        super(msg);
    }

}
