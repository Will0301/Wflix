package com.wflix.model.service;

import com.wflix.dto.locator.LocatorDTO;
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

    public Locator signIn(Locator locator){
        if(locatorRepository.getByCpf(locator.getCpf()) != null){
            return locator;
        }
        else{
            locatorRepository.save(locator);
            return locator;
        }
    }

    public List<LocatorDTO> listClient(){
        List<LocatorDTO> clients = new ArrayList<>();
        locatorRepository.findAll().forEach(client -> clients.add(LocatorMapper.mapperToDto(client)));
        return clients;
    }

    public Locator getByName(String name){
        return locatorRepository.getByNameContainingIgnoreCase(name);
    }

    public void rentMovies(String cpf, List<String> moviesIds){
        Iterable<Movie> source = movieRepository.findAllById(moviesIds);
        List<Movie> movieList = new ArrayList<>();
        source.forEach(movieList::add);

        Locator locator = locatorRepository.getByCpf(cpf);
        locator.setMovieList(movieList);
        locatorRepository.save(LocatorMapper.mapperToImpl(locator));

        movieRepository.deleteAllById(moviesIds);
    }

    public void giveBack(String cpf){
        movieRepository.saveAll(locatorRepository.getByCpf(cpf).getMovieList());
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
