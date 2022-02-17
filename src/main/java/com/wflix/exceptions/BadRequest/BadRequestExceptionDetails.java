package com.wflix.exceptions.BadRequest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class BadRequestExceptionDetails {

        private String title;
        private int status;
        private String messege;
        private LocalDateTime time;
    }


