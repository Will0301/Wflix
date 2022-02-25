package com.wflix.mappers;

import com.wflix.dto.movie.MovieDTO;
import com.wflix.model.entities.Movie;

public class MovieMapper {

    public static Movie mapperToImpl(MovieDTO movieDTO){
        return Movie.builder()
                .image(movieDTO.getImage())
                .title(movieDTO.getTitle())
                .release(movieDTO.getRelease())
                .cast(movieDTO.getCast())
                .rank(movieDTO.getRank())
                .type(movieDTO.getType())
                .build();
    }

    public static MovieDTO mapperToMovie(Movie movieDTO){
        return MovieDTO.builder()
                .id(movieDTO.getId())
                .image(movieDTO.getImage())
                .title(movieDTO.getTitle())
                .release(movieDTO.getRelease())
                .cast(movieDTO.getCast())
                .rank(movieDTO.getRank())
                .type(movieDTO.getType())
                .build();
    }
}
