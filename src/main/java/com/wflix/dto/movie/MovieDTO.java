package com.wflix.dto.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wflix.integration.model.MoviePoster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {

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

