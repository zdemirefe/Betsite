package com.Betsite.Betsite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.BetslipCustomerService;
import com.Betsite.Betsite.business.requests.CreateBetslipCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipCustomerResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.BetslipCustomerDAO;
import com.Betsite.Betsite.entities.concretes.BetslipCustomer;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BetslipCustomerManager implements BetslipCustomerService{
	
	private BetslipCustomerDAO betslipCustomerDAO;
	private ModelMapperService modelMapperService;
	@Override
	public List<GetAllBetslipCustomerResponse> getAll() {
		List<BetslipCustomer> betslipCustomer = betslipCustomerDAO.findAll();
		List<GetAllBetslipCustomerResponse> getAllBetslipCustomer = betslipCustomer.stream().map(BetslipCustomers -> this.modelMapperService.forResponse().map(BetslipCustomers,GetAllBetslipCustomerResponse.class)).collect(Collectors.toList());
		return getAllBetslipCustomer;
	}
	
	@Override
	public void add(CreateBetslipCustomerRequest createBetslipCustomerRequest) {
		BetslipCustomer betslipCustomer = this.modelMapperService.forRequest().map(createBetslipCustomerRequest, BetslipCustomer.class);
		this.betslipCustomerDAO.save(betslipCustomer);
	}

	@Override
	public void adds(ArrayList<CreateBetslipCustomerRequest> createBetslipCustomerRequest) {
		List<BetslipCustomer> getAllBetslipCustomer = createBetslipCustomerRequest.stream().map(CreateBetslipCustomerRequest -> this.modelMapperService.forResponse().map(CreateBetslipCustomerRequest,BetslipCustomer.class)).collect(Collectors.toList());
		for (BetslipCustomer betslipCustomer : getAllBetslipCustomer) {
			this.betslipCustomerDAO.save(betslipCustomer);
		}
	}
	
}
