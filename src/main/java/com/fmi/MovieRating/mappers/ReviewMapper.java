package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;

public class ReviewMapper {

    public static Review fromDtoToReview(ReviewDto reviewDto){
        return new Review(
                reviewDto.getReviewTitle(),
                reviewDto.getMovie(),
                reviewDto.getReviewerName(),
                reviewDto.getScore(),
                reviewDto.getBody()
        );
    }
}
