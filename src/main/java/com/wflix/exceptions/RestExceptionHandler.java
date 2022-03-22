package com.wflix.exceptions;

import com.wflix.exceptions.BadRequest.BadRequestExceptionDetails;
import com.wflix.exceptions.notFound.NotFoundException;
import com.wflix.exceptions.notFound.NotFoundExceptionDetails;
import com.wflix.exceptions.serverError.ForbiddenErrorDetails;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public BadRequestExceptionDetails badRequest(MethodArgumentNotValidException argumentNotValidException){
        Map<String, String> error = new HashMap<>();
        List<FieldError> errorList = argumentNotValidException.getBindingResult().getFieldErrors();
        errorList.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        return BadRequestExceptionDetails.builder()
                .status(BAD_REQUEST.value())
                .title("Invalid Request.")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check for incorrect information.")
                .build();
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundExceptionDetails notFound(){
        return NotFoundExceptionDetails.builder()
                .time(LocalDateTime.now())
                .status(NOT_FOUND.value())
                .title("Not Found")
                .details("We could not find this endpoint")
                .build();
    }

    @ResponseStatus(FORBIDDEN)
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ForbiddenErrorDetails servererror(){
        return ForbiddenErrorDetails.builder()
                .title("Forbidden")
                .time(LocalDateTime.now())
                .status(FORBIDDEN.value())
                .details("Please verify your API key, API host or if you are subscribed to this API.")
                .build();
    }
}
