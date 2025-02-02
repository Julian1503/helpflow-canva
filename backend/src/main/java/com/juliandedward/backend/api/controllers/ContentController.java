package com.juliandedward.backend.api.controllers;

import com.julian.commerceshared.repository.UseCase;
import com.juliandedward.backend.api.requests.SearchContentRequest;
import com.juliandedward.backend.application.queries.SearchContentQuery;
import com.juliandedward.backend.application.useCase.SearchContentUseCase;
import com.juliandedward.backend.domain.models.ContentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.AbstractDocument;
import java.util.Collection;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase;

    public ContentController(UseCase<SearchContentQuery, Collection<ContentModel>> searchContentUseCase) {
        this.searchContentUseCase = searchContentUseCase;
    }

    @GetMapping("/search")
    public ResponseEntity<Collection<ContentModel>> searchContent(@Validated @ModelAttribute SearchContentRequest request) {
        SearchContentQuery query = new SearchContentQuery(request.title(), request.type(), request.tags());
        Collection<ContentModel> results = searchContentUseCase.execute(query);
        return ResponseEntity.ok(results);
    }
}
