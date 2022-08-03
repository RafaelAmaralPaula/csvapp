package com.rafaelamaral.csvapp.repositories;

import com.rafaelamaral.csvapp.entities.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TemperatureRepository extends MongoRepository<Temperature , String> {
}
