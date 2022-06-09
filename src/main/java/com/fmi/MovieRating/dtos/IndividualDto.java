package com.fmi.MovieRating.dtos;

import com.fmi.MovieRating.models.enums.StarType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IndividualDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private StarType starType;
    private java.time.LocalDate birthdate;
    private String birthCountry;
    private String birthCity;
    private String bio;


    public IndividualDto() {
        id = 0;
        firstname = "";
        lastname = "";
        starType = StarType.Actor;
        birthdate = LocalDate.now();
        birthCountry = "";
        birthCity = "";
        bio = "";
    }

    public IndividualDto(String firstname, String lastname,
                         LocalDate birthdate, String birthCountry, String birthCity, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.bio = bio;
    }


    public IndividualDto(Integer id, String firstname, String lastname,
                         LocalDate birthdate, String birthCountry, String birthCity, String bio) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.bio = bio;
    }

    public IndividualDto(Integer id, String firstname, String lastname, StarType starType,
                         LocalDate birthdate, String birthCountry, String birthCity, String bio) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.starType = starType;
        this.birthdate = birthdate;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.bio = bio;
    }
}
