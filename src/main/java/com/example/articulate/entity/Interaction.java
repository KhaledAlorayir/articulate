package com.example.articulate.entity;

import com.example.articulate.enums.InteractionEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "article_id"})})
@Data
public class Interaction extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InteractionEnum type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private PlatformUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "article_id")
    private Article article;
}
