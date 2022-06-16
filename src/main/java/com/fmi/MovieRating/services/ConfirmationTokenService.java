package com.fmi.MovieRating.services;

import com.fmi.MovieRating.models.VerificationToken;
import com.fmi.MovieRating.repositories.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final VerificationTokenRepository verificationTokenRepository;

    public void saveConfirmationToken(VerificationToken token) {
        verificationTokenRepository.save(token);
    }

    public Optional<VerificationToken> getToken(String token) {
        return verificationTokenRepository.findByToken(token);
    }

    public void updateConfirmationToken(String expiredToken, String newToken) {
        Optional<VerificationToken> fromRepository = verificationTokenRepository.findByToken(expiredToken);
        fromRepository.get().setToken(newToken);
        verificationTokenRepository.save(fromRepository.get());
    }
}
