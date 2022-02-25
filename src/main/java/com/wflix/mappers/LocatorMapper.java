package com.wflix.mappers;

import com.wflix.dto.locator.LocatorDTO;
import com.wflix.model.entities.Locator;

public class LocatorMapper {

    public static LocatorDTO mapperToDto(Locator locator){
        return LocatorDTO.builder()
                .name(locator.getName())
                .movieList(locator.getMovieList())
                .build();
    }

    public static Locator mapperToImpl(Locator locator){
       return Locator.builder()
                .id(locator.getId())
                .name(locator.getName())
                .cpf(locator.getCpf())
                .movieList(locator.getMovieList())
                .build();
    }
}
