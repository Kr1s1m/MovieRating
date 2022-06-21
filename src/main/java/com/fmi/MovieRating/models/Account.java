package com.fmi.MovieRating.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "account_id")})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private Long id;

    @Column(name = "account_username", length = 25, unique = true)
    private String username;

    @Column(name = "account_email", unique = true)
    private String email;

    @Column(name = "account_password")
    private String password;

    @Column(name = "account_enabled")
    private Boolean enabled;

    @Column(name = "account_locked")
    private Boolean locked;

    @Column(name="account_date_created")
    private LocalDateTime dateCreated;

    @OneToOne(mappedBy = "account")
    VerificationToken verificationToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(	name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Review> reviews;

    public Account(String username,
                   String email,
                   String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = false;
        this.locked = false;
        dateCreated = null;
    }

    //constructor for mapper
    public Account(String username,
                   String email) {
        this.username = username;
        this.email = email;
        this.password = "password";
        this.enabled = false;
        this.locked = false;
        dateCreated = null;
    }
}

