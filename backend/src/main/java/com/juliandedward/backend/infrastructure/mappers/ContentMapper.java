package com.juliandedward.backend.infrastructure.mappers;

import com.julian.commerceshared.repository.Mapper;
import com.juliandedward.backend.domain.models.ContentModel;
import com.juliandedward.backend.infrastructure.entites.ContentEntity;
import org.springframework.stereotype.Component;

@Component
public class ContentMapper implements Mapper<ContentEntity, ContentModel> {

    @Override
    public ContentModel toSource(ContentEntity domain) {
        return null;
    }

    @Override
    public ContentEntity toTarget(ContentModel entity) {
        return null;
    }
}
