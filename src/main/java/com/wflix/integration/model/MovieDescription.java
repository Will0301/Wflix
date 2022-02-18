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

    @JsonProperty("image")
    private MoviePoster i;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String l;

    @JsonProperty("Response for")
    private String q;

    private long rank;

    @JsonProperty("cast")
    private String s;

    @JsonProperty("release")
    private long y;

}
