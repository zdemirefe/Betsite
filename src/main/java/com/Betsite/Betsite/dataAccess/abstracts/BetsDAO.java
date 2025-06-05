package com.Betsite.Betsite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Betsite.Betsite.entities.concretes.Bets;

public interface BetsDAO extends JpaRepository<Bets,Integer>{

}
