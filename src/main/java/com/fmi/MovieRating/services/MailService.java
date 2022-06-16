package com.fmi.MovieRating.services;

import com.fmi.MovieRating.models.Account;

public interface MailService {
    public void sendVerificationToken(String token, Account account);
}
