package com.ziyao.demo.redis.service;

import com.ziyao.demo.redis.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> findAll();

    Dog findById(String id);

    Dog addOrUpdate(Dog dog);

    void deleteById(String id);
}
