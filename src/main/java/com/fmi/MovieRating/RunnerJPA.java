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

        ReviewDto review1 = new ReviewDto(movie1.getId(), "Title1", "TestReviewer1", (short)5, "This is a test review", LocalDateTime.now());
        ReviewDto review2 = new ReviewDto(movie1.getId(),"Title2", "TestReviewer2", (short)5, "This is a test review", LocalDateTime.now());
        ReviewDto review3 = new ReviewDto(movie1.getId(),"Title3", "TestReviewer3", (short)5, "This is a test review", LocalDateTime.now());
        ReviewDto review4 = new ReviewDto(movie2.getId(),"Title4", "TestReviewer4", (short)5, "This is a test review", LocalDateTime.now());
        ReviewDto review5 = new ReviewDto(movie3.getId(),"Title5", "TestReviewer5", (short)5, "This is a test review", LocalDateTime.now());

        reviewService.createReview(review1);
        reviewService.createReview(review2);
        reviewService.createReview(review3);
        reviewService.createReview(review4);
        reviewService.createReview(review5);

    }
}
*/