package com.juliandedward.backend.application.useCase;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;
import com.juliandedward.backend.domain.services.CacheService;

import java.util.Collection;

public class SearchContentUseCase implements UseCase<SearchContentQuery, Collection<ContentModel>> {

    private final ContentRepository contentRepository;
    private final CacheService<Collection<ContentModel>> cacheService;

    public SearchContentUseCase(ContentRepository contentRepository, CacheService<Collection<ContentModel>> cacheService) {
        this.contentRepository = contentRepository;
        this.cacheService = cacheService;
    }

    @Override
    public Collection<ContentModel> execute(SearchContentQuery query) {
        String cacheKey = cacheService.generateKey("SearchContentUseCase", query.title(), query.type(), query.tags());
        return contentRepository.searchByFilters(query.title(), query.type(), query.tags());
    }
}
