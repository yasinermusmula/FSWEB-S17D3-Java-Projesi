package com.example.s17d3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kangaroo {
    private int id;
    private String name;
    private double weight;
    private double sleepHour;
    private String gender;
    private boolean isAgressive;
}
