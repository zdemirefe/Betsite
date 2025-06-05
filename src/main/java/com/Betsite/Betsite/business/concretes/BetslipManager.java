package com.Betsite.Betsite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.BetslipService;
import com.Betsite.Betsite.business.requests.CreateBetslipRequest;
import com.Betsite.Betsite.business.responses.GetAllBetslipResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.BetslipDAO;
import com.Betsite.Betsite.entities.concretes.Betslip;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BetslipManager implements BetslipService{

	private BetslipDAO betslipDAO;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBetslipResponse> getAll() {
		List<Betslip> betslips = betslipDAO.findAll();
		List<GetAllBetslipResponse> betslipResponse = betslips.stream().map(Betslip->this.modelMapperService.forResponse().map(Betslip,GetAllBetslipResponse.class)).collect(Collectors.toList());
		return betslipResponse;
	}

	@Override
	public void add(CreateBetslipRequest createBetslipRequest) {
		Betslip betslip = this.modelMapperService.forRequest().map(createBetslipRequest, Betslip.class);
		this.betslipDAO.save(betslip);
	}

	@Override
	public List<GetAllBetslipResponse> getById(int customer_id) {
		List<GetAllBetslipResponse> allBetslips = getAll();
		List<GetAllBetslipResponse> ourBetslips = new ArrayList<GetAllBetslipResponse>();
		for (GetAllBetslipResponse getAllBetslipResponse : allBetslips) {
			if(customer_id==getAllBetslipResponse.getCustomer_id())
			{
				ourBetslips.add(getAllBetslipResponse);
			}
		}	
		return ourBetslips;
	}
}
