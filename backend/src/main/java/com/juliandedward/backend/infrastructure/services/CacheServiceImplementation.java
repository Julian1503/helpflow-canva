package com.juliandedward.backend.infrastructure.services;

import com.juliandedward.backend.domain.services.CacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImplementation<T> implements CacheService<T> {
    private final RedisTemplate<String, T> redisTemplate;

    public CacheServiceImplementation(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setCache(String key, T value, long ttlInSeconds) {
        redisTemplate.opsForValue().set(key, value, ttlInSeconds, TimeUnit.SECONDS);
    }

    public T getCache(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void deleteCache(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public String generateKey(String serviceName, Object... keys) {
        return serviceName + ":" + String.join("::", Arrays.toString(keys));
    }
}
