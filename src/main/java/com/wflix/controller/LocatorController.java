package com.wflix.controller;

import com.wflix.dto.locator.LocatorDTO;
import com.wflix.model.entities.Locator;
import com.wflix.model.entities.Movie;
import com.wflix.model.service.LocatorService;
import com.wflix.model.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/wflix")
@AllArgsConstructor
public class LocatorController {

    private final LocatorService locatorService;
    private final MovieService movieService;

    @GetMapping("/search/{title}")
    public List<Movie> searchMovie(@PathVariable String title){
        return movieService.searchFor(title);
    }

    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/sign")
    public Locator signIn(@RequestBody Locator locator){
        return locatorService.signIn(locator);
    }

    @GetMapping("/clients")
    public List<LocatorDTO> listAllClients(){
        return locatorService.listClient();
    }

//    @GetMapping("/clients/{name}")
//    public Locator getClientByName(@PathVariable String name){
//        return getClientByName(name);
//    }

    @GetMapping("/rent")
    public void rentMovies(@RequestParam String cpf,@RequestParam List<String> moviesIds){
        locatorService.rentMovies(cpf,moviesIds);
    }

    @ResponseStatus(NO_CONTENT)
    @GetMapping("/return")
    public void giveBack(@RequestParam String cpf){
        locatorService.giveBack(cpf);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/exit")
    public void signOut(@RequestParam String cpf){
        locatorService.signOut(cpf);
    }


}
