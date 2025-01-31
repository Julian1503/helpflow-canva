package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
