package com.fmi.MovieRating.mappers;

import com.fmi.MovieRating.dtos.IndividualDto;
import com.fmi.MovieRating.models.Individual;
import com.fmi.MovieRating.repositories.IIndividualInfo;

public class IndividualMapper {

    public static Individual fromDtoToIndividual(IndividualDto individualDto){
        return new Individual(
                individualDto.getFirstname(),
                individualDto.getLastname(),
                individualDto.getBirthdate(),
                individualDto.getBirthCountry(),
                individualDto.getBirthCity(),
                individualDto.getBio()
        );
    }


    public static IndividualDto fromIndividualToDto(Individual individual) {
        return new IndividualDto(
                individual.getId(),
                individual.getFirstname(),
                individual.getLastname(),
                individual.getBirthdate(),
                individual.getBirthCountry(),
                individual.getBirthCity(),
                individual.getBio()
        );
    }

    public static IndividualDto fromIndividualInfoToDto(IIndividualInfo individualInfo) {
        return new IndividualDto(
                individualInfo.getId(),
                individualInfo.getFirstname(),
                individualInfo.getLastname(),
                individualInfo.getStarType(),
                individualInfo.getBirthdate(),
                individualInfo.getBirthCountry(),
                individualInfo.getBirthCity(),
                individualInfo.getBio()
        );
    }

}
