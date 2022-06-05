package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDto> list();

    Optional<MovieDto> getMovieById(Integer id);

    MovieDto createMovie(MovieDto movieDto);

    void deleteMovie(Integer id);

}
