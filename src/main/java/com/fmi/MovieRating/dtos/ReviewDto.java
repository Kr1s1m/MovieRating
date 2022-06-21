package com.fmi.MovieRating.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;

    //movie
    private Integer movieId;
    private String movieTitle;
    private Short movieYear;

    //account
    private Long accountId;
    private String reviewerUsername;

    //self
    private String title;
    private Short score;
    private String body;
    private LocalDateTime date;
}