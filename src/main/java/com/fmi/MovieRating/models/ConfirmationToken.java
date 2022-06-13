package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id", nullable = false)
    private Long id;

    @Column(name = "token_token", nullable = false)
    private String token;

    @Column(name = "token_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "token_expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "token_confirmed_at")
    private LocalDateTime confirmedAt;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             Account account) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.account = account;
    }
}