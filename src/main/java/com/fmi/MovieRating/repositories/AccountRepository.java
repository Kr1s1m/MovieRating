package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
