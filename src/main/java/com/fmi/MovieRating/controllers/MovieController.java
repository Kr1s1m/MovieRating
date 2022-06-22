package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.repositories.IRatingInfo;
import com.fmi.MovieRating.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.MovieMapper.fromMovieInfoToDto;
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
                    IRatingInfo ratingInfo = movieService.getRatingInfoById(movie.getId());
                    MovieDto movieDto = fromMovieToDto(movie);
                    movieDto.setRatedCount(ratingInfo.getRatedCount());
                    movieDto.setRating(ratingInfo.getRating());

                    return movieDto;
                })
                .collect(Collectors.toList());

    }

    @GetMapping("/movies/{id}")
    public Optional<MovieDto> getMovieById(@PathVariable Integer id) {

        return movieService.getMovieById(id).map(movie -> {
            IRatingInfo ratingInfo = movieService.getRatingInfoById(movie.getId());
            MovieDto movieDto = fromMovieToDto(movie);
            movieDto.setRatedCount(ratingInfo.getRatedCount());
            movieDto.setRating(ratingInfo.getRating());

            return movieDto;
        });
    }

    @GetMapping("/movies/individual-page/{individual_id}")
    public List<MovieDto> getAllByIndividualId(@PathVariable Integer individual_id){
        return movieService.getAllMovieInfoByIndividualId(individual_id).stream()
                .map(iMovieInfo -> {
                    MovieDto movieDto = fromMovieInfoToDto(iMovieInfo);

                    IRatingInfo iRatingInfo = movieService.getRatingInfoById(iMovieInfo.getId());

                    movieDto.setRatedCount(iRatingInfo.getRatedCount());
                    movieDto.setRating(iRatingInfo.getRating());
                    movieDto.setDescription("");

                    return movieDto;
                })
                .collect(Collectors.toList());
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
