package com.juliandedward.backend.application.useCase;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;

import java.util.Collection;

public class SearchContentUseCase implements UseCase<SearchContentQuery, Collection<ContentModel>> {

    private final ContentRepository contentRepository;

    public SearchContentUseCase(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public Collection<ContentModel> execute(SearchContentQuery query) {
        return contentRepository.searchByFilters(query.title(), query.type(), query.tags());
    }
}
