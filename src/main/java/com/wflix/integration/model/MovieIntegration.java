package com.wflix.integration.model;

import com.wflix.model.entities.Movie;
import lombok.Builder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Builder
public class MovieIntegration {

    private final RestTemplate restTemplate;

    public List<Movie> search(String movie){

        List<Movie> movies = new ArrayList<>();

        List<MovieDescription> movieDescription =
                Objects.requireNonNull(restTemplate.getForObject("/auto-complete?q=" + movie, MovieIMDB.class))
                        .getMovieDescription();

        movieDescription.forEach(movieDescription1 -> {
             movies.add(Movie.builder()
                    .title(movieDescription1.getL())
                    .cast(movieDescription1.getS())
                    .image(movieDescription1.getImage())
                    .id(movieDescription1.getId())
                    .rank(movieDescription1.getRank())
                    .release(movieDescription1.getY())
                    .type(movieDescription1.getQ())
                    .search(movie)
                    .build());
        });

        return movies;
    }
}
