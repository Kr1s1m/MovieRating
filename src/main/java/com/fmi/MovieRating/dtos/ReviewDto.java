package com.fmi.MovieRating.dtos;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto {
    private Integer id;
    private Integer movieId;

    private String title;
    private String reviewerName;
    private Short score;
    private String body;
    private LocalDateTime date;

    public ReviewDto() {
        id = 0;
        movieId = 0;
        title = "";
        reviewerName = "";
        score = 0;
        body = "";
        date = LocalDateTime.now();
    }

    public ReviewDto(Integer movieId, String title,
                     String reviewerName, Short score, String body, LocalDateTime date) {

        this.movieId = movieId;

        this.title = title;
        this.reviewerName = reviewerName;
        this.score = score;
        this.body = body;
        this.date = date;
    }

    //mapper constructor
    public ReviewDto(Integer id, Integer movieId, String title,
                     String reviewerName, Short score, String body, LocalDateTime date) {

        this.id = id;
        this.movieId = movieId;

        this.title = title;
        this.reviewerName = reviewerName;
        this.score = score;
        this.body = body;
        this.date = date;
    }
}