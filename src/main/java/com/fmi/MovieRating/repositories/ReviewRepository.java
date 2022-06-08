package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "select * from review as R where R.movie_id = ?1"
                    , nativeQuery = true)
    List<Review> findAllByMovieId(Integer movie_id);

    @Query(value = "select count(review_score) as voteCount, round(avg(review_score), 1) as scoreAverage from review where movie_id = ?1"
            , nativeQuery = true)
    IVoteInfo getVoteInfoByMovieId(Integer movie_id);
}
