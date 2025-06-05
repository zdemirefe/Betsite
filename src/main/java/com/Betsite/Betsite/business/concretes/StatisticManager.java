package com.Betsite.Betsite.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.StatisticService;
import com.Betsite.Betsite.business.requests.CreateStatisticRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;
import com.Betsite.Betsite.business.responses.GetAllStatisticsResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.StatisticsDAO;
import com.Betsite.Betsite.entities.concretes.Statistics;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatisticManager implements StatisticService{
	
	private StatisticsDAO statisticsDAO;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllStatisticsResponse> getAll() {
		List<Statistics> statistics = statisticsDAO.findAll();
		List<GetAllStatisticsResponse> statisticResponse = statistics.stream().map(Statistics->this.modelMapperService.forResponse().map(Statistics,GetAllStatisticsResponse.class)).collect(Collectors.toList());
		return statisticResponse;
	}

	@Override
	public void add(CreateStatisticRequest createStatisticRequest, List<GetAllBetslipResponse> betslips) {
		Statistics statistics = this.modelMapperService.forRequest().map(createStatisticRequest, Statistics.class);
		statistics.setTotal_earning(totalLoss(betslips));
		statistics.setTotal_loss(totalEarning(betslips));
		statistics.setWinrate(winRate(betslips));
		this.statisticsDAO.save(statistics);
	}
	public double totalEarning(List<GetAllBetslipResponse> betslips) 
	{
		double total_earning = 0;
		for (GetAllBetslipResponse betslip : betslips) {
			if(betslip.getBetslip_situation().equals("Win")) 
			{
				total_earning = total_earning + betslip.getBetslip_amount();  
			}
		}
		return total_earning;
	}
	public double totalLoss(List<GetAllBetslipResponse> betslips) 
	{
		double total_loss = 0;
		for (GetAllBetslipResponse betslip : betslips) {
			if(betslip.getBetslip_situation().equals("Loss")) 
			{
				total_loss = total_loss + betslip.getBetslip_amount();  
			}
		}
		return total_loss;
	}
	public float winRate(List<GetAllBetslipResponse> betslips) 
	{
		float winRate=1;
		float countWin = 0;
		float countLoss = 0;
		for (GetAllBetslipResponse betslip : betslips) {
			if(betslip.getBetslip_situation().equals("Win")) 
			{
				countWin = countWin +1;
			}
			else 
			{
				countLoss = countLoss +1;
			}
		}
		winRate = countWin / (countWin+countLoss);
		return winRate;
	}

	@Override
	public GetAllStatisticsResponse getById(int customer_id) {
		List<GetAllStatisticsResponse> statistics = getAll();
		GetAllStatisticsResponse getAllStatisticResponse = new GetAllStatisticsResponse();
		for (GetAllStatisticsResponse getAllStatisticsResponse : statistics) {
			if(getAllStatisticsResponse.getCustomer_id()==customer_id) 
			{
				getAllStatisticResponse=getAllStatisticsResponse;
			}
		}
		return getAllStatisticResponse;
	}

	
}
