package com.wflix.controller;

import com.wflix.dto.MovieDTO;
import com.wflix.dto.MovieMapper;
import com.wflix.integration.model.MovieIMDB;
import com.wflix.integration.model.MovieIntegration;
import com.wflix.model.entities.Movie;
import com.wflix.model.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @ResponseStatus(OK)
    @GetMapping
    public List<Movie> getAll(){
        return movieService.getAll();
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Movie getById(@PathVariable String id){
        return movieService.getById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public MovieDTO addMovie(@RequestBody @Valid MovieDTO movie){
        return movieService.addMovie(MovieMapper.mapperToImpl(movie));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping
    public void deleteAll(){
        movieService.deleteAll();
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        movieService.deleteById(id);
    }

    MovieIntegration movieRest;
    @GetMapping("/search/{movie}")
    public MovieIMDB search(@PathVariable String movie){
        return movieRest.search(movie);
    }

}
