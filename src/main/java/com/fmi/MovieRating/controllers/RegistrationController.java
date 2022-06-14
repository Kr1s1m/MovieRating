package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.email.EmailSender;
import com.fmi.MovieRating.email.EmailValidator;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.ConfirmationToken;
import com.fmi.MovieRating.models.enums.AccessType;
import com.fmi.MovieRating.services.AccountService;
import com.fmi.MovieRating.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final EmailSender emailSender;
    private final EmailValidator emailValidator;
    private final AccountService accountService;

    @PostMapping("/registration")
    public void register(@RequestBody RegistrationRequest registrationRequest) {

        boolean isValidEmail = emailValidator.test(registrationRequest
                .getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        Optional<Account> existingAccount = accountService.findByEmail(registrationRequest.getEmail());

        if(existingAccount.isPresent()){
            registrationService.existingAccountHandler(existingAccount.get());
        }
        else
        {
            registrationService.register(
                    new Account(
                            registrationRequest.getUsername(),
                            registrationRequest.getEmail(),
                            registrationRequest.getPassword(),
                            AccessType.User)
            );
        }

    }

    @GetMapping("/registration/confirm")
    public String confirm(@RequestParam("token") String token) {

        return registrationService.confirmToken(token);
    }
}
