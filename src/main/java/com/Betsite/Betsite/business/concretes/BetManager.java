package com.Betsite.Betsite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.BetService;
import com.Betsite.Betsite.business.requests.CreateBetRequest;
import com.Betsite.Betsite.business.responses.GetAllBetsResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.BetsDAO;
import com.Betsite.Betsite.entities.concretes.Bets;
import com.Betsite.Betsite.entities.concretes.Event;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BetManager implements BetService{
	
	private BetsDAO betsDAO;
	private ModelMapperService modelMapperService;

	
	public List<GetAllBetsResponse> getAll()
	{
		List<Bets> bets = betsDAO.findAll();
		List<GetAllBetsResponse> betsResponse = bets.stream().map(Bets->this.modelMapperService.forResponse().map(Bets,GetAllBetsResponse.class)).collect(Collectors.toList());
		return betsResponse;
	}



	@Override
	public void add(ArrayList<CreateBetRequest> createBetRequest) {
		Bets bet = modelMapperService.forRequest().map(createBetRequest, Bets.class);
		this.betsDAO.save(bet);
	}



	@Override
	public List<GetAllBetsResponse> getAllByEventId(int event_id) {
		List<GetAllBetsResponse> bets = getAll();
		List<GetAllBetsResponse> ourBets = new ArrayList<GetAllBetsResponse>();
		Event event = new Event();
		event.setEvent_id(event_id);
		for (GetAllBetsResponse getAllBetsResponse : bets) {
			if(getAllBetsResponse.getEvent_id()==event_id) 
			{
				ourBets.add(getAllBetsResponse);
			}
		}
		return ourBets;
	}
}
