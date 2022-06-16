package com.fmi.MovieRating.dtos;


import com.fmi.MovieRating.validator.PasswordMatches;
import com.fmi.MovieRating.validator.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class RegistrationRequest {
    @NotEmpty
    private String username;

    @NotEmpty
    @ValidEmail
    private String email;

    @Size(min = 6, message = "Password is less than 6 characters long.")
    private String password;

    @NotEmpty
    private String matchingPassword;
}
