package com.fmi.MovieRating.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovieDto {
    private Integer id;
    private String title;
    private Short year;
    private Integer votes;
    private Float rating;
    private String description;


    public MovieDto() {
        id = 0;
        title = "";
        year = 0;
        votes = 0;
        rating = 0.0f;
        description = "";
    }

    //constructor
    public MovieDto(String title, Short year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
        votes = 0;
        rating = 0.0f;
    }

    //constructor for mapper
    public MovieDto(Integer id, String title, Short year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }
}
