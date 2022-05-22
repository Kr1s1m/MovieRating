package com.fmi.MovieRating.models;

import javax.persistence.*;

@Entity
@Table(indexes = { @Index(columnList = "review_id") })
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "reviewer_name", length = 25)
    private String reviewerName;

    @Column(name = "review_score")
    private Short score;

    @Lob
    @Column(name = "review_body")
    private String body;

}
