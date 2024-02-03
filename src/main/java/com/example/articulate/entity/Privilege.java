package com.example.articulate.entity;

import com.example.articulate.enums.PrivilegeEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Privilege extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PrivilegeEnum name;

    @OneToMany(mappedBy = "privilege")
    private List<PlatformUser> users;
}
