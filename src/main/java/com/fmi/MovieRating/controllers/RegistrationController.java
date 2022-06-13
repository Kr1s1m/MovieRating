package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.RegistrationRequest;
import com.fmi.MovieRating.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }

    @GetMapping("/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
