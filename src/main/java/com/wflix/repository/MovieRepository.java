package com.wflix.repository;

import com.wflix.model.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findByTitleContainingIgnoreCase(String name);
}
