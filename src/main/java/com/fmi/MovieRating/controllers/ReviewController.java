package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @GetMapping("/reviews/{movie_id}")
    public List<Review> getAllByMovieID(@PathVariable Integer movie_id)
    {
        return reviewRepository.findAllByMovieId(movie_id);
    }
    //@GetMapping("/{movie_id}/reviews")
}
