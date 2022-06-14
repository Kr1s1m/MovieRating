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

    @Column(name = "token_expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public ConfirmationToken(String token,
                             LocalDateTime expiresAt,
                             Account account) {
        this.token = token;
        this.expiresAt = expiresAt;
        this.account = account;
    }
}