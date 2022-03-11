package com.wflix.exceptions.serverError;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ForbiddenErrorDetails {

    private String title;
    private int status;
    private String details;
    private LocalDateTime time;

}
