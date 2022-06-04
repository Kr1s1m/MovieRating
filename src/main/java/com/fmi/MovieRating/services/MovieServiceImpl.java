package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.fmi.MovieRating.mappers.MovieMapper.fromDtoToMovie;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public List<Movie> list(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Integer id) {

        Optional<Movie> maybeMovie = movieRepository.findById(id);

        if(maybeMovie.isPresent()) {
            return maybeMovie;
        }else {
            throw new ResourceNotFoundException(String.format("Movie with id %d does not exist", id));
        }
    }

    public Movie createMovie(MovieDto movieDto){
        Movie movie = fromDtoToMovie(movieDto);
        return movieRepository.saveAndFlush(movie);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateScoreById(Integer id, Short score) {
        Optional<Movie> movie = getMovieById(id);
        Double initialRating= movie.get().getRating();
        Double newRating = (initialRating + score)/2;
        movie.get().setRating(newRating);

        //TODO:Check for double;

        return movieRepository.saveAndFlush(movie.get());

    }
}
