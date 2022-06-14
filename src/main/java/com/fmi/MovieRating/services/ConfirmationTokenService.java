package com.fmi.MovieRating.services;

import com.fmi.MovieRating.models.ConfirmationToken;
import com.fmi.MovieRating.repositories.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public void updateConfirmationToken(String expiredToken, String newToken) {
        Optional<ConfirmationToken> fromRepository = confirmationTokenRepository.findByToken(expiredToken);
        fromRepository.get().setToken(newToken);
        confirmationTokenRepository.save(fromRepository.get());
    }
}
