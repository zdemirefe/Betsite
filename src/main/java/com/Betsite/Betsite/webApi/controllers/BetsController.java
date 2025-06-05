package com.Betsite.Betsite.webApi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Betsite.Betsite.business.abstratcs.BetService;
import com.Betsite.Betsite.business.requests.CreateBetRequest;
import com.Betsite.Betsite.business.responses.GetAllBetsResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/bets")
@CrossOrigin
public class BetsController {
	
	private BetService betService;
	@Autowired
	public BetsController(BetService betService) {
		this.betService = betService;
	}
	@GetMapping("/allbets")
	public List<GetAllBetsResponse> getAll()
	{
		return betService.getAll();
	}
	@GetMapping("/getbyeventid")
	public List<GetAllBetsResponse> getAllByEventId(int event_id)
	{
		return betService.getAllByEventId(event_id);
	}
	@PostMapping("/postbet")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody ArrayList<CreateBetRequest> createBetRequest) 
	{
		this.betService.add(createBetRequest);
	}

}
