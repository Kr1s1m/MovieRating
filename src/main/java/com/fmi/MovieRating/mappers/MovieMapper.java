package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IMovieInfo;

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

    public static MovieDto fromMovieInfoToDto(IMovieInfo movieInfo) {
        return new MovieDto(
                movieInfo.getId(),
                movieInfo.getTitle(),
                movieInfo.getYear(),
                movieInfo.getStarType()
        );
    }
}
