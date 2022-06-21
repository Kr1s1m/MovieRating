package com.fmi.MovieRating.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList = "review_id") })
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "review_title", length = 100)
    private String title;

    @Column(name = "reviewer_username", length = 25)
    private String reviewerUsername;

    @Column(name = "review_score")
    private Short score;

    @Column(name = "review_date")
    private LocalDateTime date;

    @Lob //large object, CLOB (character large object) <-> TEXT in Postgres
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "review_body", columnDefinition = "TEXT")
    private String body;


    public Review() {
        reviewerUsername = "";
        this.score = 0;
        this.body = "";
    }

    public Review(String title, String reviewerUsername, Short score, String body, LocalDateTime date) {
        this.title = title;
        this.reviewerUsername = reviewerUsername;
        this.score = score;
        this.body = body;
        this.date = date;
    }
}
