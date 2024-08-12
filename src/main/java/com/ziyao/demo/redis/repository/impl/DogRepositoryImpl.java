package com.ziyao.demo.redis.repository.impl;

import com.ziyao.demo.redis.entity.Dog;
import com.ziyao.demo.redis.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class DogRepositoryImpl implements DogRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "Dog";

    @Override
    public List<Dog> findAll() {
        Map<Object, Object> dogs = redisTemplate.opsForHash().entries(KEY);
        return dogs.values().stream()
                .map(r -> (Dog) r)
                .toList();
    }

    @Override
    public Dog findById(String id) {
        return (Dog) redisTemplate.opsForHash().get(KEY, id);
    }

    @Override
    public Dog save(Dog dog) {
        redisTemplate.opsForHash().put(KEY, dog.getId(), dog);
        return dog;
    }

    @Override
    public void deleteById(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }
}
