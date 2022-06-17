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
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/authentication")
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

    @GetMapping("/token/verify")
    public ResponseEntity<?> confirmRegistration(@NotEmpty @RequestParam("token") String token) {
        System.out.println(token);
        final String result = accountService.validateVerificationToken(token);
        return ResponseEntity.ok().body(new ApiResponse(true, result));
    }

    @GetMapping("/token/resend")
    @ResponseBody
    public ResponseEntity<?> resendRegistrationToken(@NotEmpty @RequestParam("token") String expiredToken) {
        if (!accountService.resendVerificationToken(expiredToken)) {
            return new ResponseEntity<>(new ApiResponse(false, "Token not found!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(new ApiResponse(true, "Successfully resent token"));
    }
}
