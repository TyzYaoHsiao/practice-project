package com.ziyao.demo.redis.repository;

public interface AuthRepository {

    String getToken(String token);

    void saveToken(String token);
}
