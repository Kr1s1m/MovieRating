package com.fmi.MovieRating.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @Lob //large object, CLOB (character large object) <-> TEXT in Postgres
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "review_body", columnDefinition = "TEXT")
    private String body;


    public Review() {
        reviewerName = "";
        this.score = 0;
        this.body = "";
    }

    public Review(String reviewerName, Short score, String body) {
        this.reviewerName = reviewerName;
        this.score = score;
        this.body = body;
    }
}
