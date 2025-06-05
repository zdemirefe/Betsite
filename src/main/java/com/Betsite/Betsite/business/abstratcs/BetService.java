package com.Betsite.Betsite.business.abstratcs;

import java.util.ArrayList;
import java.util.List;

import com.Betsite.Betsite.business.requests.CreateBetRequest;
import com.Betsite.Betsite.business.responses.GetAllBetsResponse;

public interface BetService {
	List<GetAllBetsResponse> getAll();
	void add(ArrayList<CreateBetRequest> createBetRequest);
	List<GetAllBetsResponse> getAllByEventId(int event_id);
}
