package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.mappers.ReviewMapper;
import com.fmi.MovieRating.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/reviews/account-page/{account_id}")
    public List<ReviewDto> getAllByAccountID(@PathVariable Long account_id)
    {
        return reviewService.getReviewsByAccountId(account_id).stream()
                .map(ReviewMapper::fromReviewToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/reviews")
    @PreAuthorize("hasAuthority('User') or hasAuthority('Admin')")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto){

        Boolean reviewExists = reviewService.existsByAccountAndMovieId(reviewDto.getAccountId(), reviewDto.getMovieId());

        if(reviewExists) {
            throw new IllegalStateException("review for movie exists");
        }
        return fromReviewToDto(reviewService.createReview(reviewDto));
    }

    @DeleteMapping("/reviews/{review_id}")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    @ResponseBody
    public void deleteReview(@PathVariable Long review_id) {
        reviewService.deleteById(review_id);
    }
}
