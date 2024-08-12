package com.ziyao.demo.mongodb.service.impl;

import com.ziyao.demo.mongodb.entity.Cat;
import com.ziyao.demo.mongodb.repository.CatRepository;
import com.ziyao.demo.mongodb.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat findById(String id) {
        return catRepository.findById(id).orElse(null);
    }

    @Override
    public Cat addOrUpdate(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteById(String id) {
        catRepository.deleteById(id);
    }
}
