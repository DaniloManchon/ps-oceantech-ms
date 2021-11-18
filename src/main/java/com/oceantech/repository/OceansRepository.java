package com.oceantech.repository;

import com.oceantech.model.Oceans;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OceansRepository extends MongoRepository<Oceans,String> {
    Oceans findByName(String name);
    void deleteByName(String name);
}
