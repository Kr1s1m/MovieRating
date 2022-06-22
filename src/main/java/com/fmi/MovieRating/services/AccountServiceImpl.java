package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.exceptions.AccountAlreadyExistAuthenticationException;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.Role;
import com.fmi.MovieRating.models.VerificationToken;
import com.fmi.MovieRating.models.enums.AccessType;
import com.fmi.MovieRating.repositories.AccountRepository;
import com.fmi.MovieRating.repositories.RoleRepository;
import com.fmi.MovieRating.repositories.VerificationTokenRepository;
import com.fmi.MovieRating.security.AccountDetails;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static com.fmi.MovieRating.mappers.AccountMapper.fromRegistrationRequestToAccount;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MailService mailService;

    @Override
    @Transactional
    public Account registerNewAccount(RegistrationRequest registrationRequest) throws AccountAlreadyExistAuthenticationException {

        if (accountRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new AccountAlreadyExistAuthenticationException("User with email " + registrationRequest.getEmail() + " already exists.");
        } else if (accountRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new AccountAlreadyExistAuthenticationException("User with username " + registrationRequest.getUsername() + " already exists.");
        }

        Account account = fromRegistrationRequestToAccount(registrationRequest);

        Set<Role> roles = new HashSet<>();
        Optional<Role> accountRole = roleRepository.findByAccessType(AccessType.User);
        if (accountRole.isEmpty()) {
            roles.add(roleRepository.save(new Role(AccessType.User)));
        } else {
            roles.add(accountRole.get());
        }

        account.setRoles(roles);

        account.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));

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
    public boolean resendVerificationToken(String existingVerificationToken) {

        Optional<VerificationToken> maybeToken = verificationTokenRepository.findByToken(existingVerificationToken);
        if (maybeToken.isPresent()) {
            VerificationToken verificationToken = maybeToken.get();

            verificationToken.updateToken(UUID.randomUUID().toString());
            verificationToken = verificationTokenRepository.save(verificationToken);
            mailService.sendVerificationToken(verificationToken.getToken(), verificationToken.getAccount());
            return true;
        }
        return false;
    }

    @Override
    public String validateVerificationToken(String token) {

        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);

        if (!verificationToken.isPresent()) {
            return "INVALID";
        }

        final Account account = verificationToken.get().getAccount();
        if (verificationToken.get().getExpiryDate().isBefore(LocalDateTime.now())) {
            return "EXPIRED";
        }

        account.setEnabled(true);
        account.setDateCreated(LocalDateTime.now());

        verificationTokenRepository.delete(verificationToken.get());
        accountRepository.save(account);

        return "VALID";
    }

    @Override
    @Transactional(readOnly = true)
    public Account getCurrentAccount() {
        AccountDetails principal = (AccountDetails) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return accountRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found - " + principal.getUsername()));
    }

}
