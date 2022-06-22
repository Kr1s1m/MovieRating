package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IMovieInfo;
import com.fmi.MovieRating.repositories.IRatingInfo;
import com.fmi.MovieRating.repositories.MovieRepository;
import com.fmi.MovieRating.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fmi.MovieRating.mappers.MovieMapper.fromDtoToMovie;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public List<Movie> list()
    {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Integer id) {

        Optional<Movie> maybeMovie = movieRepository.findById(id);

        if(maybeMovie.isPresent()) {
            return maybeMovie;
        }else {
            throw new ResourceNotFoundException(String.format("Movie with id %d does not exist", id));
        }
    }

    @Override
    public Movie createMovie(MovieDto movieDto){
        Movie movie = fromDtoToMovie(movieDto);
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public List<IMovieInfo> getAllMovieInfoByIndividualId(Integer individual_id) {
        return movieRepository.getAllMovieInfoByIndividualId(individual_id);
    }

    @Override
    public IRatingInfo getRatingInfoById(Integer id) {
        return reviewRepository.getRatingInfoByMovieId(id);
    }

    @Override
    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

}
