package com.juliandedward.backend.infrastructure.config;

import com.juliandedward.backend.domain.repositories.ContentRepository;
import com.juliandedward.backend.infrastructure.mappers.ContentMapper;
import com.juliandedward.backend.infrastructure.repositories.ContentRepositoryImplementation;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public ContentRepository contentRepository(EntityManager entityManager, ContentMapper contentMapper) {
        return new ContentRepositoryImplementation(entityManager, contentMapper);
    }
}
