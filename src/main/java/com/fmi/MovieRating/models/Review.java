package com.fmi.MovieRating.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Vote> votes;

    @Column(name = "review_title", length = 100)
    private String title;

    @Column(name = "review_score")
    private Short score;

    @Column(name = "review_date")
    private LocalDateTime date;

    @Column(name = "review_vote_balance")
    private Integer voteBalance = 0;

    @Lob //large object, CLOB (character large object) <-> TEXT in Postgres
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "review_body", columnDefinition = "TEXT")
    private String body;

    public Review(String title, Short score, String body, LocalDateTime date) {
        this.title = title;
        this.score = score;
        this.body = body;
        this.date = date;
    }
}
