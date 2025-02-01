package com.juliandedward.backend.application.config;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.application.useCase.SearchContentUseCase;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.domain.repositories.ContentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
public class ContentConfig {
    @Bean
    public UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase(ContentRepository contentRepository) {
        return new SearchContentUseCase(contentRepository);
    }
}
