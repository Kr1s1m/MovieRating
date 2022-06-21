package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> list();

    List<Review> getReviewsByMovieId(Integer id);

    List<Review> getReviewsByAccountId(Long id);

    Boolean existsByAccountAndMovieId(Long accountId, Integer movieId);

    Review createReview(ReviewDto reviewDto);

    void deleteById(Long id);
}
