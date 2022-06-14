package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.models.enums.AccessType;

public class AccountDto {
    private String id;
    private String username;
    private String email;
    private AccessType accessType;
    private Boolean enabled;
    private Boolean locked;
}
