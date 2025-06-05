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

import com.Betsite.Betsite.business.abstratcs.BetslipService;
import com.Betsite.Betsite.business.abstratcs.StatisticService;
import com.Betsite.Betsite.business.requests.CreateStatisticRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;
import com.Betsite.Betsite.business.responses.GetAllStatisticsResponse;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin
public class StatisticsController {

	private StatisticService statisticService;
	private BetslipService betslipService;
	
	@Autowired
	public StatisticsController(StatisticService statisticService) {
		this.statisticService = statisticService;
	}
	@GetMapping("/getAll")
	public List<GetAllStatisticsResponse> getAll()
	{
		return this.statisticService.getAll();
	}
	@PostMapping("/postbycustomerId")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(int customer_id) 
	{
		CreateStatisticRequest createStatisticRequest = new CreateStatisticRequest();
		List<GetAllBetslipResponse> allBetslips = betslipService.getAll();
		List<GetAllBetslipResponse> ourBetslips = new ArrayList<GetAllBetslipResponse>();
		for (GetAllBetslipResponse getAllBetslipResponse : allBetslips) {
			if(customer_id==getAllBetslipResponse.getCustomer_id())
			{
				ourBetslips.add(getAllBetslipResponse);
			}
		}
		createStatisticRequest.setCustomer_id(customer_id);
		this.statisticService.add(createStatisticRequest,ourBetslips);
	}
	@GetMapping("/customerid")
	public GetAllStatisticsResponse getAllById(int customer_id) 
	{
		return this.statisticService.getById(customer_id);
	}
}
