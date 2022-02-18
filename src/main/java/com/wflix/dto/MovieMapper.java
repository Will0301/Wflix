package com.wflix.dto;

import com.wflix.model.entities.Movie;

public class MovieMapper {

    public static Movie mapperToImpl(MovieDTO movieDTO){
        return Movie.builder()
                .title(movieDTO.getTitle())
                .release(movieDTO.getRelease())
                .build();
    }

    public static MovieDTO mapperToMovie(Movie movieDTO){
        return MovieDTO.builder()
                .title(movieDTO.getTitle())
                .release(movieDTO.getRelease())
                .build();
    }
}
