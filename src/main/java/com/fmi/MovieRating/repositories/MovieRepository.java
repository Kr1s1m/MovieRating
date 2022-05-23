package com.fmi.MovieRating.repositories;

import org.springframework.data.repository.CrudRepository;
import com.fmi.MovieRating.models.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {



}
