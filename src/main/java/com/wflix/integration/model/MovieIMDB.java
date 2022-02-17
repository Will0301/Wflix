package com.wflix.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

    @Data
    @Builder
    public class MovieIMDB {

        @JsonProperty("d")
        private List<MovieDescription> MovieDescription;

        @JsonProperty("q")
        private String query;

    }

