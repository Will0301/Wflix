package com.wflix.exceptions.notFound;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class NotFoundExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String messege;
    private LocalDateTime time;
}
