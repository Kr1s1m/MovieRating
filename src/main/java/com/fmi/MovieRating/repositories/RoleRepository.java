package com.fmi.MovieRating.repositories;

import com.fmi.MovieRating.models.Role;
import com.fmi.MovieRating.models.enums.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByAccessType(AccessType accessType);
}
