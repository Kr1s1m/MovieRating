package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.enums.AccessType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(indexes = {@Index(columnList = "account_id")})
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private Long id;

    @Column(name = "account_username", length = 25, unique = true)
    private String username; //unique

    @Column(name = "account_email", unique = true)
    private String email; //unique

    @Column(name = "account_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_access_type")
    private AccessType accessType;

    @Column(name = "account_enabled")
    private Boolean enabled;

    @Column(name="account_date_created")
    private LocalDateTime dateCreated;

    @OneToOne(mappedBy = "account")
    VerificationToken verificationToken;

    public Account(String username,
                   String email,
                   String password,
                   AccessType accessType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.accessType = accessType;
        this.enabled = false;
        dateCreated = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(accessType.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

