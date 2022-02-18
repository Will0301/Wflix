package com.wflix.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class MovieIMDB {

        @JsonProperty("d")
        private List<MovieDescription> MovieDescription;

        @JsonProperty("q")
        private String query;

    }

