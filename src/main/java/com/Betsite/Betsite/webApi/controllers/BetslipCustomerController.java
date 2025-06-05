package com.Betsite.Betsite.webApi.controllers;

import java.util.ArrayList;
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

import com.Betsite.Betsite.business.abstratcs.BetslipCustomerService;
import com.Betsite.Betsite.business.requests.CreateBetslipCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipCustomerResponse;

@RestController
@RequestMapping("/api/betslipcustomer")
@CrossOrigin
public class BetslipCustomerController {
	private BetslipCustomerService betslipCustomerService;
	@Autowired
	public BetslipCustomerController(BetslipCustomerService betslipCustomerService) {
		super();
		this.betslipCustomerService = betslipCustomerService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllBetslipCustomerResponse> getAll()
	{
		return this.betslipCustomerService.getAll();
	}
	
	@PostMapping("/postAll")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateBetslipCustomerRequest createBetslipCustomerRequest) 
	{
		this.betslipCustomerService.add(createBetslipCustomerRequest);
	}
	@PostMapping("/postAllkamonnn")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void adds(@RequestBody ArrayList<CreateBetslipCustomerRequest> createBetslipCustomerRequest) 
	{
		this.betslipCustomerService.adds(createBetslipCustomerRequest);
	}
	
}
