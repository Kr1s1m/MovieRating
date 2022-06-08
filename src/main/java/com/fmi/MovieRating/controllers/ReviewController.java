package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.mappers.ReviewMapper;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.repositories.ReviewRepository;
import com.fmi.MovieRating.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.ReviewMapper.fromReviewToDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<ReviewDto> getAllReviews(){
        return reviewService.list().stream()
                .map(ReviewMapper::fromReviewToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/reviews/{movie_id}")
    public List<ReviewDto> getAllByMovieID(@PathVariable Integer movie_id)
    {
        return reviewService.getReviewsByMovieId(movie_id).stream()
                .map(ReviewMapper::fromReviewToDto)
                .collect(Collectors.toList());
    }
    //@GetMapping("/{movie_id}/reviews")

    @PostMapping("/reviews")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto){
        return fromReviewToDto(reviewService.createReview(reviewDto));
    }
}
