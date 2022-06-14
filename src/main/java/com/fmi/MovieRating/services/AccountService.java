package com.fmi.MovieRating.services;

import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.ConfirmationToken;
import com.fmi.MovieRating.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountService implements UserDetailsService {

    private final static String ACCOUNT_NOT_FOUND_MSG =
            "account with email %s not found.";

    private final AccountRepository accountRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Account loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(ACCOUNT_NOT_FOUND_MSG, email)));
    }

    public Optional<Account> findByEmail(String email) {

        return accountRepository.findByEmail(email);
    }

    public String signUpUser(Account account) {
        String encodedPassword = bCryptPasswordEncoder
                .encode(account.getPassword());

        account.setPassword(encodedPassword);

        accountRepository.save(account);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now().plusHours(24),
                account
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        //send confirmation token

        return token;
    }

    public int enableAccount(String email) {
        return accountRepository.enableAccount(email);
    }
}
