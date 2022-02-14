package com.Wflix.dto;

import jdk.jfr.Label;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieImdbDTO {

    private String id;
    private String l;
}
