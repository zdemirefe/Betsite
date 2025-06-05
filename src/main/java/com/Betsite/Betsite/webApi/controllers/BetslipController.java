package com.Betsite.Betsite.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Betsite.Betsite.business.abstratcs.BetslipService;
import com.Betsite.Betsite.business.requests.CreateBetslipRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;

@RestController
@RequestMapping("/api/betslip")
@CrossOrigin
public class BetslipController {
	private BetslipService betslipservice;
	
	@Autowired
	public BetslipController(BetslipService betslipservice) {
		super();
		this.betslipservice = betslipservice;
	}
	@GetMapping("/betslips")
	public List<GetAllBetslipResponse> getAll()
	{
		return this.betslipservice.getAll();
	}
	@PostMapping("/createbetslip")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateBetslipRequest createBetslipRequest) 
	{
		this.betslipservice.add(createBetslipRequest);
	}
	@GetMapping("/mybetslips/customerId")
	public List<GetAllBetslipResponse> getById(int customer_id) 
	{
		return this.betslipservice.getById(customer_id);
	}
}
