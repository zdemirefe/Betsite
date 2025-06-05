package com.Betsite.Betsite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Betsite.Betsite.entities.concretes.BetslipCustomer;

public interface BetslipCustomerDAO extends JpaRepository<BetslipCustomer,Integer>{

}
