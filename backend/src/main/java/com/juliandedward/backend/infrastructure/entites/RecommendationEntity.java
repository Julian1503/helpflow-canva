package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class RecommendationEntity {

    @Id
    @GeneratedValue
    @Column(name="recommendation_id", columnDefinition = "UUID")
    private UUID id;

    private UUID userId;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private ContentEntity content;

    private String searchQuery;

    private String domainName;
}
