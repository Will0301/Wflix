package com.wflix.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wflix.integration.model.MoviePoster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    private MoviePoster image;

    private String id;

    private String title;

    private String type;

    private long rank;

    private String cast;

    private long release;

    private boolean available;

    @JsonProperty("Searched for: ")
    private String search;
}
