package com.fmi.MovieRating.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AccountDto {
    private String username;
    private LocalDate dateCreated;
}
