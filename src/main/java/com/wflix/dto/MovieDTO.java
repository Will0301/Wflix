package com.wflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {

    @NotBlank
    @Size(min = 1, max = 30, message = "Tamanho inválido")
    private String name;

    @NotBlank
    private String genre;

    private LocalDate release;
}

