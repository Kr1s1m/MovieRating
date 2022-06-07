package com.fmi.MovieRating.dtos;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieDto {
    private Integer id;
    private String title;
    private Short year;
    private String description;

    public MovieDto() {
        id = 0;
        title = "";
        year = 0;
        description = "";
    }

    //constructor
    public MovieDto(String title, Short year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
    }

    //constructor for mapper
    public MovieDto(Integer id, String title, Short year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
    }
}
