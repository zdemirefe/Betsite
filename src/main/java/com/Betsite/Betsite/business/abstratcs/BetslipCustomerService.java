package com.Betsite.Betsite.business.abstratcs;

import java.util.ArrayList;
import java.util.List;

import com.Betsite.Betsite.business.requests.CreateBetslipCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipCustomerResponse;

public interface BetslipCustomerService{
	List<GetAllBetslipCustomerResponse> getAll();
	void add(CreateBetslipCustomerRequest createBetslipCustomerRequest);
	void adds(ArrayList<CreateBetslipCustomerRequest> createBetslipCustomerRequest);
}
