package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByToken(String token);

    Optional<VerificationToken> findByAccount(Account account);
}
