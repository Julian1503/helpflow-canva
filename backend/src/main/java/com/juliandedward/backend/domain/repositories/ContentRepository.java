package com.juliandedward.backend.domain.repositories;

import com.juliandedward.backend.domain.models.ContentModel;

import java.util.Collection;
import java.util.UUID;

public interface ContentRepository {
    Collection<ContentModel> searchByFilters(String title, String type, Collection<String> tags);
    Collection<ContentModel> findRelatedContent(UUID contentId, int limit);
}
