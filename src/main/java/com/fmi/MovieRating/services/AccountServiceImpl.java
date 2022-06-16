package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.exceptions.AccountAlreadyExistAuthenticationException;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.VerificationToken;
import com.fmi.MovieRating.models.enums.AccessType;
import com.fmi.MovieRating.repositories.AccountRepository;
import com.fmi.MovieRating.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    @Transactional
    public Account registerNewAccount(RegistrationRequest registrationRequest) throws AccountAlreadyExistAuthenticationException {

        if (accountRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new AccountAlreadyExistAuthenticationException("User with email " + registrationRequest.getEmail() + " already exists");
        } else if (accountRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new AccountAlreadyExistAuthenticationException("User with username " + registrationRequest.getUsername() + " already exists");
        }

        //TODO: MAKE IT WITH MAPPER
        Account account = new Account(
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                AccessType.User);

        //TODO:TO BE SET WHEN ACCOUNT GETS ACTIVATED
        account.setDateCreated(LocalDateTime.now());

        account = accountRepository.saveAndFlush(account);

        return account;
    }

    @Override
    public Optional<Account> findAccountByEmail(String email) {

        return accountRepository.findByEmail(email);
    }

    @Override
    public Optional<Account> findAccountById(Long id) {

        return accountRepository.findById(id);
    }

    @Override
    public void createVerificationTokenForAccount(Account account, String token) {
        final VerificationToken myToken = new VerificationToken(token, account);
        verificationTokenRepository.save(myToken);
    }

    @Override
    @Transactional
    public boolean resendVerificationToken(String token) {

        return false;
    }

    @Override
    public String validateVerificationToken(String token) {

        return null;
    }
}
