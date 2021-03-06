package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "select * from review as R where R.movie_id = ?1"
                    , nativeQuery = true)
    List<Review> findAllByMovieId(Integer movie_id);

    @Query(value = "select count(review_score) as ratedCount, round(avg(review_score), 1) as rating from review where movie_id = ?1"
            , nativeQuery = true)
    IRatingInfo getRatingInfoByMovieId(Integer movie_id);

    @Query(value = "select * from review as R where R.account_id = ?1"
            , nativeQuery = true)
    List<Review> findAllByAccountId(Long account_id);

    @Query(value = "select exists(select 1 from review as R where R.account_id = ?1 and R.movie_id = ?2) AS \"exists\""
            , nativeQuery = true)
    Boolean existsByAccountAndMovieId(Long accountId, Integer movieId);

    @Query(value = "select coalesce(sum(review_vote_balance), 0) from review as R where R.account_id = ?1"
            , nativeQuery = true)
    Long getKarmaByAccountId(Long accountId);
}
