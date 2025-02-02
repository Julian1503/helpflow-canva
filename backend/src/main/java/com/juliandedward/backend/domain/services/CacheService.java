package com.juliandedward.backend.domain.services;

import com.juliandedward.backend.application.queries.RelatedContentQuery;

import java.util.concurrent.TimeUnit;

public interface CacheService<T> {
    void setCache(String key, T value, long ttlInSeconds);
    T getCache(String key);
    void deleteCache(String key);

    String generateKey(String serviceName, Object...keys);
}
