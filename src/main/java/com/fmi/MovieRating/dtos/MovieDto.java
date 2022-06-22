package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.models.enums.StarType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDto {
    private Integer id;
    private String title;
    private Short year;
    private StarType starType;
    private Integer ratedCount;
    private Float rating;
    private String description;

    //constructor
    public MovieDto(String title, Short year, String description) {
        this.title = title;
        this.year = year;
        this.description = description;
        ratedCount = 0;
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
