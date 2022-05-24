package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovieById(@PathVariable Integer id) {
        if(movieRepository.findById(id).isPresent()) {
            return movieRepository.findById(id);
        }else {
            throw new ResourceNotFoundException(String.format("Movie with id %d does not exist", id));
        }
       // return movieRepository.findById(id);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody MovieDto movieDto){
        Movie movie = new Movie(
                movieDto.getTitle(),
                movieDto.getYear(),
                movieDto.getDescription()
        );

        return movieRepository.saveAndFlush(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieRepository.deleteById(id);
    }
}
