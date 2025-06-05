package com.Betsite.Betsite.business.abstratcs;

import java.util.List;

import com.Betsite.Betsite.business.requests.CreateStatisticRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;
import com.Betsite.Betsite.business.responses.GetAllStatisticsResponse;

public interface StatisticService {
	List<GetAllStatisticsResponse> getAll();
	void add(CreateStatisticRequest createStatisticRequest,List<GetAllBetslipResponse> betslips);
	GetAllStatisticsResponse getById(int CUSTOMER_ID);
}
