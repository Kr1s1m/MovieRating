package com.fmi.MovieRating.dtos;

import lombok.Value;

import java.util.List;

@Value
public class AccountInfo {
    Long id;
    String username;
    String email;
    List<String> roles;
}
