package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer> {
    @Query(value = "select individual.individual_id as id, individual_firstname as firstname, " +
                   "individual_lastname as lastname, individual_birthdate as birthdate, " +
                   "individual_birth_country as birthCountry, individual_birth_city as birthCity, " +
                   "individual_bio as bio, star_type as starType " +
                   "from stars_in inner join individual on individual.individual_id = stars_in.individual_id " +
                   "where movie_id = ?1"
            , nativeQuery = true)
    List<IIndividualInfo> getAllIndividualInfoByMovieId(Integer movie_id);
}
