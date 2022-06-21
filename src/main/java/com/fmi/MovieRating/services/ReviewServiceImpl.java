package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.repositories.AccountRepository;
import com.fmi.MovieRating.repositories.MovieRepository;
import com.fmi.MovieRating.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fmi.MovieRating.mappers.ReviewMapper.fromDtoToReview;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final AccountRepository accountRepository;
    private final MovieRepository movieRepository;

    @Override
    public List<Review> list() {

        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByMovieId(Integer id) {

        return reviewRepository.findAllByMovieId(id);
    }

    @Override
    public List<Review> getReviewsByAccountId(Long id) {
        return reviewRepository.findAllByAccountId(id);
    }

    @Override
    public Review createReview(ReviewDto reviewDto) {
        Review review = fromDtoToReview(reviewDto);
        Integer movieId = reviewDto.getMovieId();
        Long accountId = reviewDto.getAccountId();

        review.setMovie(movieRepository.getById(movieId));
        review.setAccount(accountRepository.getById(accountId));

        return reviewRepository.saveAndFlush(review);
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

}
