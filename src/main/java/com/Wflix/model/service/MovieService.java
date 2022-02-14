package com.Wflix.model.service;

import com.Wflix.dto.MovieDTO;
import com.Wflix.dto.MovieImdbDTO;
import com.Wflix.dto.MovieMapper;
import com.Wflix.exceptions.notFound.NotFoundException;
import com.Wflix.integration.model.MoviesImdbIntegration;
import com.Wflix.model.entities.MoviesImdb;
import com.Wflix.integration.MoviesIntegrationApi;
import com.Wflix.model.entities.Movie;
import com.Wflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.Wflix.dto.MovieImdbMapper.mapperToImdb;
import static com.Wflix.dto.MovieImdbMapper.mapperToResponse;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private MoviesIntegrationApi moviesIntegrationApi;

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Movie getById(String id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Error, object not found"));
    }

    public Iterable<Movie> getAllById(List<String> ids){
        return movieRepository.findAllById(ids);
    }

    public MovieDTO addMovie(Movie movie){
        return MovieMapper.mapperToMovie(movieRepository.save(movie));

    }

    public void addAllMovie(List<Movie> movies){
        movieRepository.saveAll(movies);
    }

    public void deleteAll(){
        movieRepository.deleteAll();
    }

    public void deleteById(String id){
        movieRepository.deleteById(id);
    }

    public void deleteIds(List<String> ids){
        movieRepository.deleteAllById(ids);
    }

    //External Api
    public MoviesImdb get(MovieImdbDTO l) throws IOException, InterruptedException {
        MoviesImdb moviesResponse = moviesIntegrationApi.getFilms(l, mapperToImdb(moviesIntegrationApi.getFilms(l.getL())));
        return mapperToResponse(moviesResponse);
    }
}
