package com.wflix.integration.model;

import lombok.Builder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Builder
public class MovieIntegration {

    private final RestTemplate restTemplate;

    public MovieIMDB search(String movie){

        MovieIMDB filminho = restTemplate.getForObject("/auto-complete?q=" + movie, MovieIMDB.class);
        return filminho;

    }
}
