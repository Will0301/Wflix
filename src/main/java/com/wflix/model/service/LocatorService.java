package com.wflix.model.service;

import com.wflix.dto.locator.LocatorDTO;
import com.wflix.exceptions.notFound.NotFoundException;
import com.wflix.integration.model.MovieIntegration;
import com.wflix.mappers.LocatorMapper;
import com.wflix.model.entities.Locator;
import com.wflix.model.entities.Movie;
import com.wflix.repository.LocatorRepository;
import com.wflix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data
@AllArgsConstructor
public class LocatorService {

    private final LocatorRepository locatorRepository;
    private final MovieRepository movieRepository;
    private final MovieIntegration movieIntegration;

    public String signIn(Locator locator){
        if(locatorRepository.getByCpf(locator.getCpf()) != null){
            return "this CPF already exists";
        }
        else{
            locatorRepository.save(locator);
            return "User created \n" + LocatorMapper.mapperToDto(locator).toString();
        }
    }

    public List<LocatorDTO> listClient(){
        List<LocatorDTO> clients = new ArrayList<>();
        locatorRepository.findAll().forEach(client -> clients.add(LocatorMapper.mapperToDto(client)));
        return clients;
    }

//    public Locator getByName(String name){
//        return locatorRepository.getByNameContainingIgnoreCase(name);
//    }

    public List<String> rentMovies(String cpf, List<String> moviesIds){
        Iterable<Movie> source = movieRepository.findAllById(moviesIds);
        List<Movie> movieList = new ArrayList<>();

        List<String> returnString = new ArrayList<>();
        source.forEach(movie -> {
            if(movie.isAvailable()){
                movieList.add(movie);
                String added = movie.getTitle() + " added to your list.";
                returnString.add(added);
            }
            else{
                String notAvailable = movie.getTitle() + " is not available.";
                returnString.add(notAvailable);
            }
        });

        Locator locator = locatorRepository.getByCpf(cpf);
        if(locator == null){throw new NotFoundException("CPF: " + cpf + "not found.");}
        locator.setMovieList(movieList);
        locatorRepository.save(LocatorMapper.mapperToImpl(locator));

        source.forEach(movie -> movie.setAvailable(false));
        movieRepository.saveAll(source);

        return returnString;
    }

    public void giveBack(String cpf){
        List<Movie> movies = locatorRepository.getByCpf(cpf).getMovieList();
        movies.forEach(film -> film.setAvailable(true));
        movieRepository.saveAll(movies);
        Locator locator = locatorRepository.getByCpf(cpf);
        locator.setMovieList(null);

        locatorRepository.save(LocatorMapper.mapperToImpl(locator));
    }

    public void signOut(String cpf){
        if(locatorRepository.getByCpf(cpf).getMovieList() == null){
            locatorRepository.deleteByCpf(cpf);
        }
        else {
            movieRepository.saveAll(locatorRepository.getByCpf(cpf).getMovieList());
            giveBack(cpf);
            locatorRepository.deleteByCpf(cpf);
        }
    }
}
