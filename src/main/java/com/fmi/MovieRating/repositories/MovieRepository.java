package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value =  "select movie.movie_id as id, movie_title as title, " +
                    "movie_year as year, star_type as starType " +
                    "from stars_in inner join movie on movie.movie_id = stars_in.movie_id " +
                    "where individual_id = ?1"
                , nativeQuery = true)
    List<IMovieInfo> getAllMovieInfoByIndividualId(Integer individual_id);

}
