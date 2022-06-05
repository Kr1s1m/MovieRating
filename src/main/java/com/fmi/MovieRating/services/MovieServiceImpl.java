package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.mappers.MovieMapper;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<MovieDto> list()
    {
        return movieRepository.findAll().stream()
                .map(MovieMapper::fromMovieToDto)
                .collect(Collectors.toList());
    }

    public Optional<MovieDto> getMovieById(Integer id) {

        Optional<MovieDto> maybeMovieDto = movieRepository.findById(id).map(MovieMapper::fromMovieToDto);

        if(maybeMovieDto.isPresent()) {
            return maybeMovieDto;
        }else {
            throw new ResourceNotFoundException(String.format("Movie with id %d does not exist", id));
        }
    }

    public MovieDto createMovie(MovieDto movieDto){
        Movie movie = fromDtoToMovie(movieDto);
        return fromMovieToDto(movieRepository.saveAndFlush(movie));
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteById(id);
    }

}
