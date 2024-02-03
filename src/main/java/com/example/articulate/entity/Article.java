package com.example.articulate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.example.articulate.constant.Constants.Default.ARTICLE_BODY_MAX_LENGTH;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Article extends BaseEntity {
/*
* Article fields (all required):
Title (less than 100 characters)
Body (less than 500 characters)
Author (the logged in username)
CreatedAt (Date and time)
Image (less than 500 KB) (a plus)
Number of likes
Number of dislikes
Disabled (boolean)

* */
    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = ARTICLE_BODY_MAX_LENGTH)
    private String body;

    @Column(nullable = false)
    private boolean isDisabled = false;

    private String imageKey;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private PlatformUser author;
}
