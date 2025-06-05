package com.Betsite.Betsite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Betsite.Betsite.entities.concretes.Betslip;

public interface BetslipDAO extends JpaRepository<Betslip,Integer>{

}
