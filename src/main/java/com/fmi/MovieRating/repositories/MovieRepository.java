package com.fmi.MovieRating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fmi.MovieRating.models.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
