package com.juliandedward.backend.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContentInteractionModel {
    private UUID id;
    private UUID userId;
    private UUID contentId;
    private String type;
    private LocalDateTime timestamp;
}
