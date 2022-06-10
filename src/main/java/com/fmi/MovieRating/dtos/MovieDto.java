package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.models.enums.StarType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {
    private Integer id;
    private String title;
    private Short year;
    private StarType starType;
    private Integer votes;
    private Float rating;
    private String description;


    public MovieDto() {
        id = 0;
        title = "";
        year = 0;
        starType = StarType.Default;
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
    //constructor for mapper
    public MovieDto(Integer id, String title, Short year, StarType starType) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.starType = starType;
    }
}
