package com.fmi.MovieRating.services;

import java.util.Map;
import java.util.Optional;

import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.exceptions.AccountAlreadyExistAuthenticationException;
import com.fmi.MovieRating.models.Account;


//TODO LOOK ACCOUNT, ACCDTO, REGISTRATIONREQUESTDTO

public interface AccountService {

    public Account registerNewAccount(RegistrationRequest registrationRequest) throws AccountAlreadyExistAuthenticationException;

    Optional<Account> findAccountByEmail(String email);

    Optional<Account> findAccountById(Long id);

    //LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);

    void createVerificationTokenForAccount(Account account, String token);

    boolean resendVerificationToken(String token);

    String validateVerificationToken(String token);
}
