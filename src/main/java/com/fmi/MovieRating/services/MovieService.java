package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> list();

    Optional<Movie> getMovieById(Integer id);

    Movie createMovie(MovieDto movieDto);

    void deleteMovie(Integer id);

    Movie updateScoreById(Integer id, Short score);

}
