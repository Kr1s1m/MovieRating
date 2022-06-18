package com.fmi.MovieRating.models;

import com.fmi.MovieRating.models.enums.AccessType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="role_access_type")
    private AccessType accessType;

    public Role(AccessType accessType) {
        this.accessType = accessType;
    }
}
