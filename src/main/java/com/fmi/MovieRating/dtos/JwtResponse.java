package com.fmi.MovieRating.dtos;

import lombok.Value;

@Value
public class JwtResponse {
    String token;
    String type = "Bearer";
    AccountInfo accountInfo;
}
