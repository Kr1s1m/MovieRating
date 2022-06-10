package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.IndividualDto;
import com.fmi.MovieRating.models.Individual;
import com.fmi.MovieRating.repositories.IIndividualInfo;

import java.util.List;
import java.util.Optional;

public interface IndividualService {

    List<Individual> list();

    Optional<Individual> getIndividualById(Integer id);

    List<IIndividualInfo> getIndividualsByMovieId(Integer id);

    Individual createIndividual(IndividualDto individualDto);

    void deleteIndividual(Integer id);
}
