package com.springpractice.roulette.rouletteapispring.service.roulette;

import com.springpractice.roulette.rouletteapispring.dto.ResultMessageDTO;
import com.springpractice.roulette.rouletteapispring.model.Roulette;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRouletteService {

    ResponseEntity<Roulette> createRoulette(Roulette roulette);

    ResponseEntity<ResultMessageDTO> openRoulette(String id);
}
