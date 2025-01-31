package com.juliandedward.backend.infrastructure.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class ContentEntity {

    @Id
    @Column(name="content_id", columnDefinition = "UUID")
    private Long id;

    private String title;

    private String type;

    @OneToMany(mappedBy = "content_tag", cascade = CascadeType.ALL)
    private Set<TagEntity> tags;

    @OneToMany(mappedBy = "content_interaction", cascade = CascadeType.ALL)
    private Set<ContentInteractionEntity> interactions;

    @OneToMany(mappedBy = "content_metadata", cascade = CascadeType.ALL)
    private Set<ContentMetadataEntity> metadata;
}