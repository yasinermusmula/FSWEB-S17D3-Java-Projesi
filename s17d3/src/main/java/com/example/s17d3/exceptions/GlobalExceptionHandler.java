package com.example.s17d3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleException(ZooException zooException){
        ZooErrorResponse koalaErrorResponse = new ZooErrorResponse(zooException.getStatus().value(),
                zooException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(koalaErrorResponse,zooException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleException(Exception exception){
        ZooErrorResponse koalaErrorResponse =
                new ZooErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(koalaErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
