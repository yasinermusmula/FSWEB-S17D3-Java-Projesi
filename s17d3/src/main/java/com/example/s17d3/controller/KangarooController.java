package com.example.s17d3.controller;

import com.example.s17d3.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class KangarooController {

    private Map<Integer, Kangaroo> kangarooMap;

    @PostConstruct
    public void init(){
        kangarooMap = new HashMap<>();
    }

    @GetMapping("/kangaroos")
    public List<Kangaroo> findAll(){
        return  kangarooMap.values().stream().toList();
    }

    @GetMapping("/kangaroos/{id}")
    public Kangaroo findById(@PathVariable int id){
        return kangarooMap.get(id);
    }

    @PostMapping("/kangaroos")
    public Kangaroo save(@PathVariable Kangaroo kangaroo){
        kangarooMap.put(kangaroo.getId(),kangaroo);
        return kangarooMap.get(kangaroo.getId());
    }

    @PutMapping("/kangaroos/{id}")
    public Kangaroo update(@PathVariable Kangaroo kangaroo,
                           @PathVariable int id){
        kangarooMap.put(id,kangaroo);
        return kangarooMap.get(id);
    }

    @DeleteMapping("/kangaroos/{id}")
    public Kangaroo remove(@PathVariable int id){
        Kangaroo kangaroo = kangarooMap.get(id);
        kangarooMap.remove(id);
        return kangaroo;
    }
}
