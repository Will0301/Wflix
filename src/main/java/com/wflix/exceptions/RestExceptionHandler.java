package com.wflix.exceptions;

import com.wflix.exceptions.BadRequest.BadRequestExceptionDetails;
import com.wflix.exceptions.notFound.NotFoundException;
import com.wflix.exceptions.notFound.NotFoundExceptionDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BadRequestExceptionDetails badRequest(){
        return BadRequestExceptionDetails.builder()
                .time(LocalDateTime.now())
                .status(BAD_REQUEST.value())
                .title("Bad Request Exception")
                .messege("Please verify your request something went wrong.")
                .build();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundExceptionDetails notFound(){
        return NotFoundExceptionDetails.builder()
                .time(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .title("Not Found")
                .details("")
                .build();
    }
}
