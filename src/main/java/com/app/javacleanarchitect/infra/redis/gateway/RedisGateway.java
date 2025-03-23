package com.app.javacleanarchitect.infra.redis.gateway;

public interface RedisGateway<T> {
    T saveToRedis(String keys, T value);
    T fetchFromRedis(String keys);
    void removeFromRedis(String keys);
}
