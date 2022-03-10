package com.wflix.dto.locator;

import com.wflix.model.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class LocatorDTO {


    @NotBlank
    private String name;

    private List<Movie> movieList;
}
