package com.juliandedward.backend.domain.models;

import com.juliandedward.backend.domain.valueObject.Title;
import com.juliandedward.backend.domain.valueObject.Type;

import java.util.Collection;

public class ContentModel {
    private Title title;
    private Type type;
    private Collection<TagModel> tags;
    private Collection<ContentMetadataModel> metadata;
    private Collection<ContentInteractionModel> interactions;
    private int viewCount;
    private int likeCount;
}
