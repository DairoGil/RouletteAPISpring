package com.springpractice.roulette.rouletteapispring.persistence;

import com.springpractice.roulette.rouletteapispring.model.Roulette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouletteDAO extends JpaRepository<Roulette, Integer> {
}
