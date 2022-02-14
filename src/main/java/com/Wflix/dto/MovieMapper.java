package com.Wflix.dto;

import com.Wflix.model.entities.Movie;

public class MovieMapper {

    public static Movie mapperToImpl(MovieDTO movieDTO){
        return Movie.builder()
                .name(movieDTO.getName())
                .release(movieDTO.getRelease())
                .genre(movieDTO.getGenre())
                .build();
    }

    public static MovieDTO mapperToMovie(Movie movieDTO){
        return MovieDTO.builder()
                .name(movieDTO.getName())
                .release(movieDTO.getRelease())
                .genre(movieDTO.getGenre())
                .build();
    }
}
