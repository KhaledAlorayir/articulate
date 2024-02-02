package com.example.articulate.repository;

import com.example.articulate.entity.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PlatformUser, Long> {
}
