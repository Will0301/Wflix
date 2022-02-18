package com.wflix.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDescription {

    @JsonProperty("i")
    private MoviePoster image;

    @JsonProperty("id")
    private String id;

    @JsonProperty("l")
    private String l;

    @JsonProperty("q")
    private String q;

    private long rank;

    @JsonProperty("s")
    private String s;

    @JsonProperty("y")
    private long y;

}
