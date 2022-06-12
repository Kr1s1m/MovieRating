package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.enums.UserAccessType;
import com.fmi.MovieRating.models.registration.token.ConfirmationToken;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users", indexes = { @Index(columnList = "user_id") })
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", unique = true)
    private String username; //unique

    @Column(name = "email", unique = true)
    private String email; //unique

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_access_type")
    private UserAccessType userAccessType;

    @Column(name = "locked", unique = true)
    private Boolean locked = false;

    @Column(name = "enabled", unique = true)
    private Boolean enabled = false;

    @OneToMany(mappedBy = "user")
    Set<ConfirmationToken> confirmationTokens = new HashSet<>();

    public User(String firstName,
                String lastName,
                String username,
                String email,
                String password,
                UserAccessType userAccessType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userAccessType = userAccessType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                 new SimpleGrantedAuthority(userAccessType.name());
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
        return !locked;
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

