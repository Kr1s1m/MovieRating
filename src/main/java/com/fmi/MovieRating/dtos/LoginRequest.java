package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.validator.ValidEmail;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {

    @NotBlank
    //@ValidEmail
    String email;

    @NotBlank
    String password;
}
