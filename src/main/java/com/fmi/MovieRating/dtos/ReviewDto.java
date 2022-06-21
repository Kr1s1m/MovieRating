package com.fmi.MovieRating.dtos;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto {
    private Long id;
    private Integer movieId;
    private Long accountId;

    private String title;
    private String reviewerUsername;
    private Short score;
    private String body;
    private LocalDateTime date;

    public ReviewDto() {
        id = Long.valueOf(0);
        movieId = 0;
        accountId=Long.valueOf(0);
        title = "";
        reviewerUsername = "";
        score = 0;
        body = "";
        date = LocalDateTime.now();
    }

    public ReviewDto(Integer movieId, Long accountId, String title,
                     String reviewerUsername, Short score, String body, LocalDateTime date) {

        this.movieId = movieId;
        this.accountId = accountId;

        this.title = title;
        this.reviewerUsername = reviewerUsername;
        this.score = score;
        this.body = body;
        this.date = date;
    }

    //mapper constructor
    public ReviewDto(Long id, Integer movieId, Long accountId, String title,
                     String reviewerUsername, Short score, String body, LocalDateTime date) {

        this.id = id;
        this.movieId = movieId;
        this.accountId = accountId;

        this.title = title;
        this.reviewerUsername = reviewerUsername;
        this.score = score;
        this.body = body;
        this.date = date;
    }
}