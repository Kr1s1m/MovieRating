package com.fmi.MovieRating.models;


import javax.persistence.*;
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
    private java.sql.Date birthdate;

    @Column(name = "individual_birth_country", length = 20)
    private String birthCountry;

    @Column(name = "individual_birth_city", length = 20)
    private String birthCity;

    @Lob
    @Column(name = "individual_bio")
    private String bio;

    @OneToMany(mappedBy = "individual")
    private Set<StarsIn> starredAs;

}
