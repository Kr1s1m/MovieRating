package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.ReviewDto;
import com.fmi.MovieRating.mappers.ReviewMapper;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.repositories.MovieRepository;
import com.fmi.MovieRating.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.ReviewMapper.fromDtoToReview;
import static com.fmi.MovieRating.mappers.ReviewMapper.fromReviewToDto;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    private final MovieRepository movieRepository;

    @Override
    public List<ReviewDto> list() {

        return reviewRepository.findAll().stream()
                .map(ReviewMapper::fromReviewToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getReviewsByMovieId(Integer id) {

        return reviewRepository.findAllByMovieId(id).stream()
                .map(ReviewMapper::fromReviewToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = fromDtoToReview(reviewDto);
        Integer movieId = reviewDto.getMovieId();

        review.setMovie(movieRepository.getById(movieId));

        return fromReviewToDto(reviewRepository.saveAndFlush(review));
    }

    @Override
    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }

}
