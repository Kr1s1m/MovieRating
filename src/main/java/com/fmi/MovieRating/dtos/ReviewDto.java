package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.models.Movie;
import lombok.Getter;

@Getter
public class ReviewDto {
    private String reviewTitle;
    private Movie movie;
    private String reviewerName;
    private Short score;
    private String body;
}
