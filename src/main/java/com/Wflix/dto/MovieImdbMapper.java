package com.Wflix.dto;

import com.Wflix.model.entities.MoviesImdb;

public class MovieImdbMapper {

    public static MoviesImdb mapperToImdb(MovieImdbDTO movieIntegration){
        return MoviesImdb.builder()
                .id(movieIntegration.getId())
                .l(movieIntegration.getL())
                .build();
    }

    public static MovieImdbDTO mapperToResponse(MoviesImdb moviesImdb){
        return MovieImdbDTO.builder()
                .id(moviesImdb.getId())
                .l(moviesImdb.getL())
                .build();
    }

}
