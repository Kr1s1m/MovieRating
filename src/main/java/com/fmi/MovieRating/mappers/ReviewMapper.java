package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

public class ReviewMapper {

    public static Review fromDtoToReview(ReviewDto reviewDto){
        return new Review(
                reviewDto.getTitle(),
                reviewDto.getReviewerName(),
                reviewDto.getScore(),
                reviewDto.getBody(),
                reviewDto.getDate()
        );
    }

    public static ReviewDto fromReviewToDto(Review review){
        return new ReviewDto(
                review.getId(),
                review.getMovie().getId(),
                review.getTitle(),
                review.getReviewerName(),
                review.getScore(),
                review.getBody(),
                review.getDate()
        );
    }
}
