package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.MovieRepository;

import com.fmi.MovieRating.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/movies")
    public List<MovieDto> getAllMovies(){
        return movieService.list();
    }

    @GetMapping("/movies/{id}")
    public Optional<MovieDto> getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public MovieDto createMovie(@RequestBody MovieDto movieDto){
      return movieService.createMovie(movieDto);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }
}
