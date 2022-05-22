package com.fmi.MovieRating.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = { @Index(columnList = "movie_id")  })
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Integer id;

    @Column(name = "movie_rating", precision = 3, scale = 1)
    private Double rating;

    @Column(name = "movie_rev_cnt")
    private Integer reviewCount;

    @Column(name = "movie_title", nullable = false, length = 70)
    private String title;

    @Column(name = "movie_year") //Short over Integer (<-> smallint over int in Postgres)
    private Short year;

    @Lob //large object, CLOB (character large object) <-> TEXT in Postgres
    @Column(name = "movie_desc")
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "movie")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "movie")
    private Set<StarsIn> starredIn;

}
