package com.juliandedward.backend.application.config;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.application.queries.RelatedContentQuery;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.application.useCase.GetRelatedContentUseCase;
import com.juliandedward.backend.application.useCase.SearchContentUseCase;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;
import com.juliandedward.backend.domain.services.CacheService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class ContentConfig {
    @Bean
    public UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase(ContentRepository contentRepository,CacheService<Collection<ContentModel>> cacheService) {
        return new SearchContentUseCase(contentRepository, cacheService);
    }

    @Bean
    public UseCase<RelatedContentQuery, Collection<ContentModel>> getRelatedContentUseCase(ContentRepository contentRepository, CacheService<Collection<ContentModel>> cacheService){
        return new GetRelatedContentUseCase(contentRepository, cacheService);
    }
}
