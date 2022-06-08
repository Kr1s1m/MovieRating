package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IVoteInfo;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> list();

    Optional<Movie> getMovieById(Integer id);

    Movie createMovie(MovieDto movieDto);

    IVoteInfo getVoteInfoById(Integer id);

    void deleteMovie(Integer id);

}
