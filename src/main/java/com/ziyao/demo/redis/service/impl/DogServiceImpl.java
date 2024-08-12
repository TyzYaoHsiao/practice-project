package com.ziyao.demo.redis.service.impl;

import com.ziyao.demo.redis.entity.Dog;
import com.ziyao.demo.redis.repository.DogRepository;
import com.ziyao.demo.redis.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    @Override
    public Dog findById(String id) {
        return dogRepository.findById(id);
    }

    @Override
    public Dog addOrUpdate(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public void deleteById(String id) {
        dogRepository.deleteById(id);
    }
}
