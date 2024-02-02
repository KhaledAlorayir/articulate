package com.example.articulate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class PlatformUser extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username, email, password;
    @Column(nullable = false, unique = true, length = 15)
    private String mobileNumber;
    @ManyToOne
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;
}
