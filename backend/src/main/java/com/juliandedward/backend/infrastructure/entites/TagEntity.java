package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class TagEntity {
    @Id
    @GeneratedValue
    @Column(name="tag_id", columnDefinition = "UUID")
    private UUID id;
    private String name;
    @Column(nullable = false)
    private UUID contentId;
}
