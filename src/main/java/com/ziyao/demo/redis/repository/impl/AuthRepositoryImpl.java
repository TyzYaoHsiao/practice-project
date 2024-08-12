package com.ziyao.demo.redis.repository.impl;

import com.ziyao.demo.redis.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class AuthRepositoryImpl implements AuthRepository {

    private static final long EXPIRE_TIME = 5;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public String getToken(String token) {
        return stringRedisTemplate.opsForValue().get(token);
    }

    @Override
    public void saveToken(String token) {
        stringRedisTemplate.opsForValue().set(token, token, EXPIRE_TIME, TimeUnit.MINUTES);
    }
}
