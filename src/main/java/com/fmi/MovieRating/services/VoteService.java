package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.VoteDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.models.Vote;
import com.fmi.MovieRating.models.enums.VoteType;
import com.fmi.MovieRating.repositories.ReviewRepository;
import com.fmi.MovieRating.repositories.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void vote(VoteDto voteDto, Account account)
    {
        Review review = reviewRepository.findById(voteDto.getReviewId())
                .orElseThrow(() -> new ResourceNotFoundException("Review Not Found with ID - " + voteDto.getReviewId()));

        Optional<Vote> voteByReviewAndAccount = voteRepository.findTopByReviewAndAccountOrderByVoteIdDesc(review, account);

        if (voteByReviewAndAccount.isPresent() &&
                voteByReviewAndAccount.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new IllegalStateException("You have already "
                    + voteDto.getVoteType().name() + "d this review");
        }
        if (VoteType.Upvote.equals(voteDto.getVoteType())) {
            review.setVoteBalance(review.getVoteBalance() + 1);
        } else {
            review.setVoteBalance(review.getVoteBalance() - 1);
        }

        voteRepository.save(
                new Vote(
                        voteDto.getVoteType(),
                        review,
                        account
                        ));

        reviewRepository.save(review);
    }
}
