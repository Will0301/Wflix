package com.wflix.model.service;

import com.wflix.integration.model.MovieIntegration;
import com.wflix.model.entities.Movie;
import com.wflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final MovieIntegration movieIntegration;


    public List<Movie> searchFor(String title){
        if(movieRepository.findByTitleContainingIgnoreCase(title).isEmpty()){
            movieRepository.saveAll(movieIntegration.search(title));
            return movieIntegration.search(title);
        }
        else return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}