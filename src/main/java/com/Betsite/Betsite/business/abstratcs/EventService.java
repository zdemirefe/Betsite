package com.Betsite.Betsite.business.abstratcs;

import java.util.List;

import com.Betsite.Betsite.business.requests.CreateEventRequest;
import com.Betsite.Betsite.business.responses.GetAllEventsResponse;

public interface EventService {
	List<GetAllEventsResponse> getAll();
	void add(CreateEventRequest createEventRequest);
	List<GetAllEventsResponse> getAllByCategory(String category);
	
}
