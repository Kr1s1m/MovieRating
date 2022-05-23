package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.enums.StarType;

import javax.persistence.*;


@Entity
@Table(indexes = { @Index(columnList = "star_id") })
public class StarsIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "star_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "individual_id", nullable = false)
    private Individual individual;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_type")
    private StarType type;

    public StarsIn() {
        type = StarType.ACTOR;
    }

    public StarsIn(StarType type) {
        this.type = type;
    }

    public StarsIn(Movie movie, Individual individual, StarType type) {
        this.movie = movie;
        this.individual = individual;
        this.type = type;
    }

    public StarType getType() {
        return type;
    }

    public void setType(StarType type) {
        this.type = type;
    }
}
