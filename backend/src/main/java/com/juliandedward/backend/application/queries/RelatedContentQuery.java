package com.juliandedward.backend.application.queries;

import java.util.UUID;

public record RelatedContentQuery (UUID contentId, int limit) {
}
