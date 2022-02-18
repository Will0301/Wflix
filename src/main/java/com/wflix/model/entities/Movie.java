package com.wflix.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wflix.integration.model.MoviePoster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @JsonProperty("Searched for: ")
    private String search;
}
