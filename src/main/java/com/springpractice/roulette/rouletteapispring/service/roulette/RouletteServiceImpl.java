package com.springpractice.roulette.rouletteapispring.service.roulette;

import com.springpractice.roulette.rouletteapispring.model.Roulette;
import com.springpractice.roulette.rouletteapispring.persistence.IRouletteDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RouletteServiceImpl implements IRouletteService{

    private IRouletteDAO rouletteDAO;

    @Autowired
    public RouletteServiceImpl(IRouletteDAO rouletteDAO) { this.rouletteDAO = rouletteDAO; }

    @Override
    public ResponseEntity<Roulette> createRoulette(Roulette roulette) {
        Roulette newRoulette = rouletteDAO.save(roulette);
        return new ResponseEntity<Roulette>(newRoulette, HttpStatus.CREATED);
    }

}
