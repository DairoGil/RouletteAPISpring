package com.springpractice.roulette.rouletteapispring.service.roulette;

import com.springpractice.roulette.rouletteapispring.model.Roulette;
import com.springpractice.roulette.rouletteapispring.persistence.IRouletteDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RouletteServiceImplTest {

    @Mock
    private IRouletteDAO rouletteRepository;
    private IRouletteService rouletteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        rouletteService = new RouletteServiceImpl(rouletteRepository);
    }

    @Test
    void createRoulette() {
        Roulette roulette = new Roulette();
        roulette.setId(1);
        roulette.setOpen(false);
        when(rouletteRepository.save(roulette)).thenReturn(roulette);
        assertEquals(roulette.getId(), rouletteService.createRoulette(roulette));

    }
}