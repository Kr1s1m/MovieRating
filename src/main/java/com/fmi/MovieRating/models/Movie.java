package com.fmi.MovieRating.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "movie_desc", columnDefinition = "TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "movie")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "movie")
    private Set<StarsIn> starredIn;

    public Movie(String title, Short year, String description)
    {
        this.rating = 0.0;
        this.reviewCount = 0;
        this.title = title;
        this.year = year;
        this.description = description;
        this.reviews = new HashSet<>();
        this.starredIn = new HashSet<>();
    }

    public Movie()
    {
        rating = 0.0;
        reviewCount = 0;
        title = "";
        year = 0;
        description = "";
        reviews = new HashSet<>();
        starredIn = new HashSet<>();
    }
}
