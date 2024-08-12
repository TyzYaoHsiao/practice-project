package com.ziyao.demo.mongodb.repository;

import com.ziyao.demo.mongodb.entity.Cat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends MongoRepository<Cat, String>{

}
