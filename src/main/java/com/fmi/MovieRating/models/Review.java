package com.fmi.MovieRating.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "review_title", length = 100)
    private String title;

    @Column(name = "reviewer_name", length = 25)
    private String reviewerName;

    @Column(name = "review_score")
    private Short score;

    @Column(name = "review_date")
    private LocalDateTime date;

    @Lob //large object, CLOB (character large object) <-> TEXT in Postgres
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "review_body", columnDefinition = "TEXT")
    private String body;


    public Review() {
        reviewerName = "";
        this.score = 0;
        this.body = "";
    }

    public Review(String title, String reviewerName, Short score, String body, LocalDateTime date) {
        this.title = title;
        this.reviewerName = reviewerName;
        this.score = score;
        this.body = body;
        this.date = date;
    }
}
