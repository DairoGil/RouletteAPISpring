package com.springpractice.roulette.rouletteapispring.service.roulette;

import com.springpractice.roulette.rouletteapispring.dto.ResultMessageDTO;
import com.springpractice.roulette.rouletteapispring.model.Roulette;
import com.springpractice.roulette.rouletteapispring.persistence.IRouletteDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RouletteServiceImplTest {

    @Mock
    private IRouletteDAO rouletteRepository;
    @Mock
    private IRouletteService rouletteService;
    private Roulette roulette;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        roulette = new Roulette();
    }

    @Test
    void createRoulette() {
        roulette.setId(1);
        roulette.setOpen(false);
        when(rouletteRepository.save(roulette)).thenReturn(roulette);
        assertEquals(roulette.getId(), rouletteService.createRoulette(roulette));

    }

    @Test
    void openRoulette() {
        roulette.setId(1);
        roulette.setOpen(false);
        when(rouletteRepository.getById(1)).thenReturn(roulette);
        assertEquals(false, rouletteRepository.getById(1).isOpen());
        ResultMessageDTO resultMessageDTO = new ResultMessageDTO();
        when(rouletteService.openRoulette("1")).
                thenReturn(new ResponseEntity<>(resultMessageDTO,HttpStatus.OK));
        assertEquals(HttpStatus.OK, rouletteService.openRoulette("1").getStatusCode());
    }
}