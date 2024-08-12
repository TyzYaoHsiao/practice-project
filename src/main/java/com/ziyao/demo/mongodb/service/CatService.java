package com.ziyao.demo.mongodb.service;

import com.ziyao.demo.mongodb.entity.Cat;

import java.util.List;

public interface CatService {

    List<Cat> findAll();

    Cat findById(String id);

    Cat addOrUpdate(Cat cat);

    void deleteById(String id);
}
