package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.enums.StarType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
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

    public StarsIn(Movie movie, Individual individual, StarType type) {
        this.movie = movie;
        this.individual = individual;
        this.type = type;
    }
}
