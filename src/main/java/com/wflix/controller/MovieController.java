//package com.wflix.controller;
//
//import com.wflix.dto.movie.MovieDTO;
//import com.wflix.mappers.MovieMapper;
//import com.wflix.model.entities.Movie;
//import com.wflix.model.service.MovieService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//import static org.springframework.http.HttpStatus.*;
//
//@RestController
//@RequestMapping("/movies")
//@AllArgsConstructor
//public class MovieController {
//
//    private final MovieService movieService;
//
//    @ResponseStatus(OK)
//    @GetMapping
//    public List<Movie> getAll(){
//        return movieService.getAll();
//    }
//
//    @GetMapping("/{title}")
//    public List<Movie> getByTitle(@PathVariable String title){
//        List<Movie> dataList = movieService.getByTitle(title);
//        return movieService.getByTitle(title);
//    }
//
//    @ResponseStatus(OK)
//    @GetMapping("/id/{id}")
//    public Movie getById(@PathVariable String id){
//        return movieService.getById(id);
//    }
//
//    @ResponseStatus(CREATED)
//    @PostMapping
//    public MovieDTO addMovie(@RequestBody @Valid MovieDTO movie){
//        return movieService.addMovie(MovieMapper.mapperToImpl(movie));
//    }
//
//    @ResponseStatus(NO_CONTENT)
//    @DeleteMapping
//    public void deleteAll(){
//        movieService.deleteAll();
//    }
//
//    @ResponseStatus(NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable String id){
//        movieService.deleteById(id);
//    }
//
//    @GetMapping("/search/{movie}")
//    public List<Movie> search(@PathVariable String movie){
//        movieService.addAllMovie(movieService.search(movie));
//        return movieService.search(movie);
//
//    }
//
//}
