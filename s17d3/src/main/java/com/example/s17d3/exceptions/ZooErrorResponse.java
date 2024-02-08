package com.example.s17d3.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZooErrorResponse {
    private int status;
    private String message;
    private LocalDateTime createdAt;
}
