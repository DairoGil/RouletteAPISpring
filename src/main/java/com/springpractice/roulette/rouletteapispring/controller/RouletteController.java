package com.springpractice.roulette.rouletteapispring.controller;

import com.springpractice.roulette.rouletteapispring.model.Roulette;
import com.springpractice.roulette.rouletteapispring.service.roulette.RouletteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roulettes")
public class RouletteController {

    @Autowired
    RouletteServiceImpl rouletteService;

    @PostMapping("/create")
    public ResponseEntity<Roulette> createRoulettes(@RequestBody Roulette roulette){
        return rouletteService.createRoulette(roulette);
    }
}