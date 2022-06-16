package com.fmi.MovieRating.dtos;

import lombok.Value;

@Value
public class ApiResponse {
    private Boolean success;
    private String message;
}
