package com.example.articulate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class PlatformUser extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username, email;

    @Column(nullable = false, unique = true, length = 15)
    private String mobileNumber;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

    @OneToMany(mappedBy = "author")
    List<Article> articles;

    public PlatformUser(String username, String email, String password, String mobileNumber, Privilege privilege) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.privilege = privilege;
    }
}
