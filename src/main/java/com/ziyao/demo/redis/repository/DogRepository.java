package com.ziyao.demo.redis.repository;

import com.ziyao.demo.redis.entity.Dog;

import java.util.List;

public interface DogRepository {

    List<Dog> findAll();

    Dog findById(String id);

    Dog save(Dog dog);

    void deleteById(String id);
}
