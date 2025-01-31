package com.juliandedward.backend.domain.models;

import com.juliandedward.backend.infrastructure.entites.ContentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContentInteractionModel {
    private UUID id;
    private UUID userId;
    private UUID contentId;
    private String type;
    private LocalDateTime timestamp;
}
