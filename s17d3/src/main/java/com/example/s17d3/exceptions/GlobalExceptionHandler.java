package com.example.s17d3.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ZooException.class)
    public ResponseEntity<ZooErrorResponse> handleException(ZooException zooException){
        log.error("ZooException occured! Exception details: " + zooException.getMessage());
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(zooException.getStatus().value(),
                zooException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(zooErrorResponse,zooException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ZooErrorResponse> handleAllException(Exception exception){
        ZooErrorResponse zooErrorResponse =
                new ZooErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(zooErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
