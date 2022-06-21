/*

package com.fmi.MovieRating;

import com.fmi.MovieRating.dtos.MovieDto;
import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.models.StarsIn;
import com.fmi.MovieRating.mappers.ReviewMapper;
import com.fmi.MovieRating.repositories.MovieRepository;
import com.fmi.MovieRating.services.MovieService;
import com.fmi.MovieRating.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static com.fmi.MovieRating.mappers.ReviewMapper.fromDtoToReview;

@Component
public class RunnerJPA implements CommandLineRunner {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @Transactional
    @Override
    public void run(String... args) {

        Movie movie1 = movieService.createMovie(new MovieDto("TestMovie1", (short)2022, "This is a test movie"));
        Movie movie2 = movieService.createMovie(new MovieDto("TestMovie2", (short)2022, "This is a test movie"));
        Movie movie3 = movieService.createMovie(new MovieDto("TestMovie3", (short)2022, "This is a test movie"));
        Movie movie4 = movieService.createMovie(new MovieDto("TestMovie4", (short)2022, "This is a test movie"));
        Movie movie5 = movieService.createMovie(new MovieDto("TestMovie5", (short)2022, "This is a test movie"));
        Movie movie6 = movieService.createMovie(new MovieDto("TestMovie6", (short)2022, "This is a test movie"));
    }
}

*/
