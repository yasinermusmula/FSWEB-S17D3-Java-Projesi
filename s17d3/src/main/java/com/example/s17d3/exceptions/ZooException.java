package com.example.s17d3.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ZooException extends RuntimeException{
    private HttpStatus status;

    public ZooException(String message, HttpStatus status){
        super(message);
        this.status=status;
    }
}
