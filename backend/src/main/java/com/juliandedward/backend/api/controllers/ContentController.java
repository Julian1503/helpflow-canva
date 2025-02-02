package com.juliandedward.backend.api.controllers;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.api.requests.SearchContentRequest;
import com.juliandedward.backend.application.queries.RelatedContentQuery;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.application.useCase.SearchContentUseCase;
import com.juliandedward.backend.domain.models.ContentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase;
    private final UseCase<RelatedContentQuery, Collection<ContentModel>> getRelatedContentUseCase;

    public ContentController(UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase, UseCase<RelatedContentQuery, Collection<ContentModel>> getRelatedContentUseCase) {
        this.searchContentUseCase = searchContentUseCase;
        this.getRelatedContentUseCase = getRelatedContentUseCase;
    }

    @GetMapping("/{contentId}/related")
    public ResponseEntity<Collection<ContentModel>> getRelatedContent(
            @PathVariable UUID contentId,
            @RequestParam(defaultValue = "5") int limit) {

        RelatedContentQuery query = new RelatedContentQuery(contentId, limit);
        Collection<ContentModel> results = getRelatedContentUseCase.execute(query);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/search")
    public ResponseEntity<Collection<ContentModel>> searchContent(@Validated @ModelAttribute SearchContentRequest request) {
        SearchContentQuery query = new SearchContentQuery(request.title(), request.type(), request.tags());
        Collection<ContentModel> results = searchContentUseCase.execute(query);
        return ResponseEntity.ok(results);
    }
}
