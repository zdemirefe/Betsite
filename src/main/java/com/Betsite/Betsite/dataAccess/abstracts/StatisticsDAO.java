package com.Betsite.Betsite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Betsite.Betsite.entities.concretes.Statistics;

public interface StatisticsDAO extends JpaRepository<Statistics,Integer>{

}
