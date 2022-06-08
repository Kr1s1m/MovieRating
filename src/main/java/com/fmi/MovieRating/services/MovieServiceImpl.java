package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.mappers.MovieMapper;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IVoteInfo;
import com.fmi.MovieRating.repositories.MovieRepository;
import com.fmi.MovieRating.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.MovieMapper.fromDtoToMovie;
import static com.fmi.MovieRating.mappers.MovieMapper.fromMovieToDto;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public List<Movie> list()
    {
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

    public IVoteInfo getVoteInfoById(Integer id) {
        return reviewRepository.getVoteInfoByMovieId(id);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

}
