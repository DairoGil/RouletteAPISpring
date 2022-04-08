package com.springpractice.roulette.rouletteapispring.service.roulette;

import com.springpractice.roulette.rouletteapispring.dto.ResultMessageDTO;
import com.springpractice.roulette.rouletteapispring.model.Roulette;
import com.springpractice.roulette.rouletteapispring.persistence.IRouletteDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;

@Service
@Slf4j
public class RouletteServiceImpl implements IRouletteService{

    @Autowired
    private IRouletteDAO rouletteDAO;

    @Override
    public ResponseEntity<Roulette> createRoulette(Roulette roulette) {
        Roulette newRoulette = rouletteDAO.save(roulette);
        return new ResponseEntity<Roulette>(newRoulette, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResultMessageDTO> openRoulette(String id) {
        ResultMessageDTO resultMessageDTO = new ResultMessageDTO();
        try{
            Roulette roulette = rouletteDAO.getById(Integer.parseInt(id));
            if (roulette.isOpen()) {
                resultMessageDTO.setMessage("The roulette is already open");
                return new ResponseEntity<ResultMessageDTO>(resultMessageDTO, HttpStatus.BAD_REQUEST);
            }
            roulette.setOpen(true);
            rouletteDAO.save(roulette);
            resultMessageDTO.setMessage("Roulette opened");
            return new ResponseEntity<ResultMessageDTO>(resultMessageDTO,HttpStatus.OK);
        }catch (EntityNotFoundException e){
            resultMessageDTO.setMessage("The roulette doesn't exist");
            return new ResponseEntity<ResultMessageDTO>(resultMessageDTO, HttpStatus.NOT_FOUND);
        }
    }

}
