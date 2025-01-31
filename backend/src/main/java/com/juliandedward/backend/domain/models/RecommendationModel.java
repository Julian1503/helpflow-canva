package com.juliandedward.backend.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class RecommendationModel {
    private UUID id;
    private UUID userId;
    private LocalDateTime timestamp;
    private ContentModel content;
    private String searchQuery;
    private String domainName;
}
