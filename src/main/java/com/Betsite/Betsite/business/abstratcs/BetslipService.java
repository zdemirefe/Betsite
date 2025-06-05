package com.Betsite.Betsite.business.abstratcs;

import java.util.List;

import com.Betsite.Betsite.business.requests.CreateBetslipRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;

public interface BetslipService {
	List<GetAllBetslipResponse> getAll();
	void add(CreateBetslipRequest createBetslipRequest);
	List<GetAllBetslipResponse> getById(int CUSTOMER_ID);
}
