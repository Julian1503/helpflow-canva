package com.juliandedward.backend.application.useCase;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.application.queries.RelatedContentQuery;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;
import com.juliandedward.backend.domain.services.CacheService;

import java.util.Collection;

public class GetRelatedContentUseCase implements UseCase<RelatedContentQuery, Collection<ContentModel>> {

    private final ContentRepository contentRepository;
    private final CacheService<Collection<ContentModel>> cacheService;

    public GetRelatedContentUseCase(ContentRepository contentRepository, CacheService<Collection<ContentModel>> cacheService) {
        this.contentRepository = contentRepository;
        this.cacheService = cacheService;
    }

    @Override
    public Collection<ContentModel> execute(RelatedContentQuery query) {
        String cacheKey = cacheService.generateKey("GetRelatedContentUseCase", query.contentId().toString(), query.limit());
        Collection<ContentModel> cachedResults = cacheService.getCache(cacheKey);
        if(cachedResults != null) {
            return cachedResults;
        }
        return contentRepository.findRelatedContent(query.contentId(), query.limit());
    }
}
