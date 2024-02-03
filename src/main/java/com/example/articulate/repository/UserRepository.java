package com.example.articulate.repository;

import com.example.articulate.entity.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<PlatformUser, Long> {
    @Query("SELECT u FROM PlatformUser u JOIN FETCH u.privilege p WHERE u.username ILIKE :identifier " +
            "OR u.email ILIKE :identifier " +
            "OR u.mobileNumber ILIKE :identifier")
    Optional<PlatformUser> findByIdentifier(String identifier);

}
