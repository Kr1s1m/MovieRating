package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fmi.MovieRating.mappers.ReviewMapper.fromDtoToReview;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    private final MovieService movieService;

    @Override
    public List<Review> list() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByMovieId(Integer id) {
        return reviewRepository.findAllByMovieId(id);
    }

    @Override
    public Review createReview(ReviewDto reviewDto) {
        Review review = fromDtoToReview(reviewDto);

        Integer movieId = reviewDto.getMovie().getId();
        Short score = reviewDto.getScore();
        movieService.updateScoreById(movieId, score);

        return reviewRepository.saveAndFlush(review);
    }

    @Override
    public void delete(Integer id) {
        reviewRepository.deleteById(id);
    }

}
