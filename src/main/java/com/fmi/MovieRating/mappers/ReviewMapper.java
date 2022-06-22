package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

public class ReviewMapper {

    public static Review fromDtoToReview(ReviewDto reviewDto){
        return new Review(
                reviewDto.getTitle(),
                reviewDto.getScore(),
                reviewDto.getBody(),
                reviewDto.getDate()
        );
    }

    public static ReviewDto fromReviewToDto(Review review){
        return new ReviewDto(
                review.getId(),
                //movie
                review.getMovie().getId(),
                review.getMovie().getTitle(),
                review.getMovie().getYear(),
                //account
                review.getAccount().getId(),
                review.getAccount().getUsername(),
                //self
                review.getTitle(),
                review.getScore(),
                review.getBody(),
                review.getDate(),
                review.getVoteBalance()
        );
    }
}
