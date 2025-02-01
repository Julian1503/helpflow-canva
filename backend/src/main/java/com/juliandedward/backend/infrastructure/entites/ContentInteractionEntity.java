package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.*;
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
    private String type;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private ContentEntity content_interaction;
}