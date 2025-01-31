package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ContentInteractionEntity {

    @Id
    @GeneratedValue
    @Column(name="interaction_id",columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID contentId;

    @Column(nullable = false)
    private String type;

    private LocalDateTime timestamp;
}