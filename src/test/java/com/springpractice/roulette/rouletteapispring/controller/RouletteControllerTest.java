package com.springpractice.roulette.rouletteapispring.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RouletteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    void createRoulettes() throws Exception {
        this.mockMvc.perform(post("/roulettes/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{ \"state\":false}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.open").value(false));
    }

    @Test
    void openRoulette() throws Exception {
        this.mockMvc.perform(put("/roulettes/open/15"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}