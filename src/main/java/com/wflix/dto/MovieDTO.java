package com.wflix.dto;

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

        private String query;

        private long rank;

        private String cast;

        private long release;
}

