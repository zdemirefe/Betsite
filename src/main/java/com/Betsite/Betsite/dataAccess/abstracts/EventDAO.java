package com.Betsite.Betsite.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Betsite.Betsite.entities.concretes.Event;

public interface EventDAO extends JpaRepository<Event,Integer>{

}
