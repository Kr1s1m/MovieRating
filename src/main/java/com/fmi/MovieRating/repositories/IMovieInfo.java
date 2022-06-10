package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.enums.StarType;

public interface IMovieInfo {
    Integer getId();
    String getTitle();
    Short getYear();
    StarType getStarType();
}
