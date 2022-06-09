package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fmi.MovieRating.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
