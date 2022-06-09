package com.fmi.MovieRating.services;

import com.fmi.MovieRating.dtos.IndividualDto;
import com.fmi.MovieRating.exceptions.ResourceNotFoundException;
import com.fmi.MovieRating.models.Individual;
import com.fmi.MovieRating.models.Movie;
import com.fmi.MovieRating.repositories.IIndividualInfo;
import com.fmi.MovieRating.repositories.IndividualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fmi.MovieRating.mappers.IndividualMapper.fromDtoToIndividual;

@Service
@RequiredArgsConstructor
public class IndividualServiceImpl implements IndividualService{


    private final IndividualRepository individualRepository;

    @Override
    public List<Individual> list(){
        return individualRepository.findAll();
    }

    @Override
    public Optional<Individual> getIndividualById(Integer id) {

        Optional<Individual> maybeIndividual = individualRepository.findById(id);

        if(maybeIndividual.isPresent()) {
            return maybeIndividual;
        }else {
            throw new ResourceNotFoundException(String.format("Individual with id %d does not exist", id));
        }
    }

    @Override
    public List<IIndividualInfo> getIndividualsByMovieId(Integer id){
        return individualRepository.getAllInfoByMovieId(id); //TODO getIndividualsByMovieId
    }

    @Override
    public Individual createIndividual(IndividualDto individualDto){
        Individual individual = fromDtoToIndividual(individualDto);
        return individualRepository.saveAndFlush(individual);
    }

    @Override
    public void deleteIndividual(Integer id){
        individualRepository.deleteById(id);
    }
}
