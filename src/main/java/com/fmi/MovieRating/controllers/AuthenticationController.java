package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.ApiResponse;
import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.exceptions.AccountAlreadyExistAuthenticationException;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.services.AccountService;
import com.fmi.MovieRating.services.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @Autowired
    AccountService accountService;

    @Autowired
    MailService mailService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Account account = accountService.registerNewAccount(registrationRequest);
            final String token = UUID.randomUUID().toString();
            accountService.createVerificationTokenForAccount(account, token);
            mailService.sendVerificationToken(token, account);


        } catch (AccountAlreadyExistAuthenticationException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
    }
}
