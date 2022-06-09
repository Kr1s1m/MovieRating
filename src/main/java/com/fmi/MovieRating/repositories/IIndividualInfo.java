package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Individual;
import com.fmi.MovieRating.models.enums.StarType;

import java.time.LocalDate;

public interface IIndividualInfo {
    Integer getId();
    String getFirstname();
    String getLastname();
    LocalDate getBirthdate();
    String getBirthCity();
    String getBirthCountry();
    String getBio();
    StarType getStarType();
}
