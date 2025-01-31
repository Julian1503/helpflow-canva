package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class ContentMetadataEntity {
    @Id
    @GeneratedValue
    @Column(name="content_metadata_id", columnDefinition = "UUID")
    private String id;
    private String title;
    private String description;
    private String type;

    @Column(nullable = false)
    private UUID contentId;
}
