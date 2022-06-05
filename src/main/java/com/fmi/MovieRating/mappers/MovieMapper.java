package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.models.Movie;

public class MovieMapper {

    public static Movie fromDtoToMovie(MovieDto movieDto) {
        return new Movie(
                movieDto.getTitle(),
                movieDto.getYear(),
                movieDto.getDescription()
        );
    }

    public static MovieDto fromMovieToDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getYear(),
                movie.getDescription()
        );
    }
}
