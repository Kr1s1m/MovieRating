package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> list();

    List<Review> getReviewsByMovieId(Integer id);

    Review createReview(ReviewDto reviewDto);

    void delete(Integer id);
}