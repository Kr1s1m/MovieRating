package com.fmi.MovieRating;

/*
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.models.Review;
import com.fmi.MovieRating.models.StarsIn;
import com.fmi.MovieRating.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class RunnerJPA implements CommandLineRunner {

    @Autowired
    private MovieRepository repo;

    @Transactional
    @Override
    public void run(String... args) {

        repo.deleteAll();

        Movie movie = new Movie( "Bad movie", (short) 3401, "This is a very bad movie.");

        Movie savedMovie = repo.save(movie);

        savedMovie.setDescription("updated description.");

        repo.save(savedMovie);

    }
}
*/