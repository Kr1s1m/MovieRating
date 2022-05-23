package com.fmi.MovieRating.models;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(indexes = { @Index(columnList = "individual_id") })
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "individual_id")
    private Integer id;

    @Column(name = "individual_firstname", length = 20)
    private String firstname;

    @Column(name = "individual_lastname", length = 20)
    private String lastname;

    @Column(name = "individual_birthdate")
    private java.time.LocalDate birthdate;

    @Column(name = "individual_birth_country", length = 20)
    private String birthCountry;

    @Column(name = "individual_birth_city", length = 20)
    private String birthCity;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "individual_bio", columnDefinition = "TEXT")
    private String bio;

    @OneToMany(mappedBy = "individual")
    private Set<StarsIn> starredAs;

    public Individual() {
        this.firstname = "";
        this.lastname = "";
        this.birthdate = LocalDate.now();
        this.birthCountry = "";
        this.birthCity = "";
        this.bio = "";
    }

    public Individual(String firstname, String lastname, LocalDate birthdate, String birthCountry, String birthCity, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.bio = bio;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
