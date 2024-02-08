package com.example.s17d3.controller;

import com.example.s17d3.entity.Koala;
import com.example.s17d3.validation.ZooKoalaValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class KoalaController {

    private Map<Integer, Koala> koalaMap;

    @PostConstruct
    public void init(){
        koalaMap = new HashMap<>();
    }

    @PostMapping("/koalas")
    public Koala save(@RequestBody Koala koala){
        ZooKoalaValidation.isKoalaCredentialValid(koala);
        koalaMap.put(koala.getId(), koala);
        return koalaMap.get(koala.getId());
    }

    @GetMapping("/koalas")
    public List<Koala> findAll(){
        return koalaMap.values().stream().toList();
    }

    @GetMapping("/koalas/{id}")
    public Koala findById(@PathVariable int id){
        ZooKoalaValidation.isIdNotValid(id);
        ZooKoalaValidation.isKoalaNotExist(koalaMap,id);
        return koalaMap.get(id);
    }


    @PutMapping("/koalas/{id}")
    public Koala update(@PathVariable Koala koala,
                        @PathVariable int id){
        koalaMap.put(id,new Koala(id,koala.getName(),koala.getWeight(),koala.getSleepHour(),koala.getGender()));
        return koalaMap.get(id);
    }

    @DeleteMapping("/koalas/{id}")
    public Koala remove(@PathVariable int id){
        Koala koala = koalaMap.get(id);
        koalaMap.remove(id);
        return koala;
    }
}
