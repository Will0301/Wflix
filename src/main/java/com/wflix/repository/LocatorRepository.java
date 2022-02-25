package com.wflix.repository;

import com.wflix.model.entities.Locator;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocatorRepository extends MongoRepository<Locator, String> {
    Locator getByNameContainingIgnoreCase(String name);

    Locator getByCpf(String cpf);

    void deleteByCpf(String cpf);
}
