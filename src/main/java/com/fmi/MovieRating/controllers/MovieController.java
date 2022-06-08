package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.mappers.MovieMapper;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IVoteInfo;
import com.fmi.MovieRating.repositories.MovieRepository;

import com.fmi.MovieRating.services.MovieServiceImpl;
import com.fmi.MovieRating.services.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.MovieMapper.fromMovieToDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @GetMapping("/movies")
    public List<MovieDto> getAllMovies(){
        return movieService.list().stream()
                .map(movie -> {
                    IVoteInfo voteInfo = movieService.getVoteInfoById(movie.getId());
                    MovieDto movieDto = fromMovieToDto(movie);
                    movieDto.setVotes(voteInfo.getVoteCount());
                    movieDto.setRating(voteInfo.getScoreAverage());

                    return movieDto;
                })
                .collect(Collectors.toList());

    }

    @GetMapping("/movies/{id}")
    public Optional<MovieDto> getMovieById(@PathVariable Integer id) {

        return movieService.getMovieById(id).map(movie -> {
            IVoteInfo voteInfo = movieService.getVoteInfoById(movie.getId());
            MovieDto movieDto = fromMovieToDto(movie);
            movieDto.setVotes(voteInfo.getVoteCount());
            movieDto.setRating(voteInfo.getScoreAverage());

            return movieDto;
        });
    }

    @PostMapping("/movies")
    public MovieDto createMovie(@RequestBody MovieDto movieDto){

        return fromMovieToDto(movieService.createMovie(movieDto));
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }
}
