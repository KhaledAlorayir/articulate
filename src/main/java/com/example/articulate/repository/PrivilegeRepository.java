package com.example.articulate.repository;

import com.example.articulate.entity.Privilege;
import com.example.articulate.enums.PrivilegeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Optional<Privilege> findByName(PrivilegeEnum privilegeEnum);
}
