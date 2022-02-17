package com.wflix.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Builder
public class MovieRest {

    private final RestTemplate restTemplate;

    public MovieRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public void call(String filme){
//        this.restTemplate.postForObject("http://localhost:8181/fabrica/v1/funcionario/cadastro",movieIMDB, MovieIMDB.class);
//    }
}
