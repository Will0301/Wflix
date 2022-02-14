package com.Wflix.integration;


import com.Wflix.dto.MovieImdbDTO;
import com.Wflix.integration.model.MoviesImdbIntegration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
public class MoviesIntegrationApi {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    private RestTemplate restTemplate;
//    public MoviesImdb getFilms(String films) throws IOException, InterruptedException {
//        String uri = "https://imdb8.p.rapidapi.com/auto-complete";
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        httpHeaders.add("x-rapidapi-host", "imdb8.p.rapidapi.com");
//        httpHeaders.add("x-rapidapi-key", "108abdd2f4msh1b627092924ac42p1a4cf1jsn14d423951b26");
//        return getRestTemplate().getForObject(uri, MoviesImdb.class);
//    }

    public MovieImdbDTO getFilms(String l) {
        UriComponents baseUri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("imdb8.p.rapidapi.com")
                .path("/auto-complete".concat(l))
                .queryParam("x-rapidapi-key", "108abdd2f4msh1b627092924ac42p1a4cf1jsn14d423951b26")
                .build();

        return restTemplate.getForObject(baseUri.toUri(), MovieImdbDTO.class);
    }
}
