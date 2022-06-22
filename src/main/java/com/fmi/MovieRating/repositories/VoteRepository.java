package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByReviewAndAccountOrderByVoteIdDesc(Review review, Account account);
}
