package com.juliandedward.backend.infrastructure.repositories;

import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;
import com.juliandedward.backend.infrastructure.entites.ContentEntity;
import com.juliandedward.backend.infrastructure.mappers.ContentMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public class ContentRepositoryImplementation implements ContentRepository {

    private final EntityManager entityManager;

    private final ContentMapper contentMapper;

    public ContentRepositoryImplementation(EntityManager entityManager, ContentMapper contentMapper) {
        this.entityManager = entityManager;
        this.contentMapper = contentMapper;
    }

    @Override
    public Collection<ContentModel> searchByFilters(String title, String type, Collection<String> tags) {
        StringBuilder queryStr = new StringBuilder("SELECT c FROM ContentEntity c WHERE 1=1");

        if (title != null && !title.isEmpty()) {
            queryStr.append(" AND c.title LIKE :title");
        }
        if (type != null && !type.isEmpty()) {
            queryStr.append(" AND c.type = :type");
        }
        if (tags != null && !tags.isEmpty()) {
            queryStr.append(" AND EXISTS (SELECT t FROM TagEntity t WHERE t.content.id = c.id AND t.name IN :tags)");
        }

        TypedQuery<ContentEntity> query = entityManager.createQuery(queryStr.toString(), ContentEntity.class);

        if (title != null && !title.isEmpty()) {
            query.setParameter("title", "%" + title + "%");
        }
        if (type != null && !type.isEmpty()) {
            query.setParameter("type", type);
        }
        if (tags != null && !tags.isEmpty()) {
            query.setParameter("tags", tags);
        }

        return query.getResultList().stream()
                .map(contentMapper::toSource)
                .toList();
    }

    @Override
    public Collection<ContentModel> findRelatedContent(UUID contentId, int limit) {
        String queryStr = """
            SELECT DISTINCT c
            FROM ContentEntity c
            JOIN TagEntity t ON c.id = t.content_tag.id
            WHERE t.name IN (
                SELECT t2.name
                FROM TagEntity t2
                WHERE t2.content_tag.id = :contentId
            )
            AND c.id != :contentId
            ORDER BY c.interactions.size DESC
        """;

        TypedQuery<ContentEntity> query = entityManager.createQuery(queryStr, ContentEntity.class);
        query.setParameter("contentId", contentId);
        query.setMaxResults(limit);

        return query.getResultList().stream()
                .map(contentMapper::toSource)
                .toList();
    }
}
