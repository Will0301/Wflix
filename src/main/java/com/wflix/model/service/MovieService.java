package com.wflix.model.service;

import com.wflix.dto.MovieDTO;
import com.wflix.dto.MovieMapper;
import com.wflix.exceptions.notFound.NotFoundException;
import com.wflix.integration.model.MovieIMDB;
import com.wflix.integration.model.MovieIntegration;
import com.wflix.model.entities.Movie;
import com.wflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final MovieIntegration movieRest;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Error, object not found"));
    }

    public Iterable<Movie> getAllById(List<String> ids) {
        return movieRepository.findAllById(ids);
    }

    public MovieDTO addMovie(Movie movie) {
        return MovieMapper.mapperToMovie(movieRepository.save(movie));

    }

    public void addAllMovie(List<Movie> movies) {
        movieRepository.saveAll(movies);
    }

    public void deleteAll() {
        movieRepository.deleteAll();
    }

    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }

    public void deleteIds(List<String> ids) {
        movieRepository.deleteAllById(ids);
    }


}