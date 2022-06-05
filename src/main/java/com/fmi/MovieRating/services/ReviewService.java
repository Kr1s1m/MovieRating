package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> list();

    List<ReviewDto> getReviewsByMovieId(Integer id);

    ReviewDto createReview(ReviewDto reviewDto);

    void deleteReview(Integer id);
}
