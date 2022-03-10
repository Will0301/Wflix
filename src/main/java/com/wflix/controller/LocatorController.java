package com.wflix.controller;

import com.wflix.dto.locator.LocatorDTO;
import com.wflix.model.entities.Locator;
import com.wflix.model.entities.Movie;
import com.wflix.model.service.LocatorService;
import com.wflix.model.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/wflix")
@AllArgsConstructor
@Api(value = "Wflix movies")
public class LocatorController {

    private final LocatorService locatorService;
    private final MovieService movieService;

    @ApiOperation(value = "Search for the title you would like to watch.")
    @GetMapping("/search/{title}")
    public List<Movie> searchMovie(@PathVariable String title){
        return movieService.searchFor(title);
    }

    @ApiOperation(value = "Shows all the movies ready to be located.")
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @ApiOperation(value = "Sign in your user.")
    @ResponseStatus(CREATED)
    @PostMapping("/sign")
    public Locator signIn(@RequestBody @Valid Locator locator){
        return locatorService.signIn(locator);
    }

    @ApiOperation(value = "Shows all the clients the rent store has.")
    @GetMapping("/clients")
    public List<LocatorDTO> listAllClients(){
        return locatorService.listClient();
    }

    @ApiOperation(value = "Lets you rent one or more movies.")
    @GetMapping("/rent")
    public void rentMovies(@RequestParam String cpf,@RequestParam List<String> moviesIds){
        locatorService.rentMovies(cpf,moviesIds);
    }

    @ApiOperation(value = "Return the movies you have rented.")
    @ResponseStatus(NO_CONTENT)
    @GetMapping("/return")
    public void giveBack(@RequestParam String cpf){
        locatorService.giveBack(cpf);
    }

    @ApiOperation(value = "Deletes your registration.")
    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/exit")
    public void signOut(@RequestParam String cpf){
        locatorService.signOut(cpf);
    }


}
