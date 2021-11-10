package com.oceantech.repository;

import com.oceantech.model.Caracteristicas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CaracteristicasRepository extends MongoRepository<Caracteristicas,String> {
}
