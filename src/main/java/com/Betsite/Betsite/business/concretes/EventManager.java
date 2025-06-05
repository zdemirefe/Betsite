package com.Betsite.Betsite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.EventService;
import com.Betsite.Betsite.business.requests.CreateEventRequest;
import com.Betsite.Betsite.business.responses.GetAllEventsResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.EventDAO;
import com.Betsite.Betsite.entities.concretes.Event;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventManager implements EventService{
	
	private EventDAO eventDAO;
	private ModelMapperService modelMapperService;


	@Override
	public List<GetAllEventsResponse> getAll() {
		List<Event> events = eventDAO.findAll();
		List<GetAllEventsResponse> eventResponse = events.stream().map(Event->this.modelMapperService.forResponse().map(Event,GetAllEventsResponse.class)).collect(Collectors.toList());
		return eventResponse;

	}

	@Override
	public void add(CreateEventRequest createEventRequest) {
		Event event = modelMapperService.forRequest().map(createEventRequest, Event.class);
		this.eventDAO.save(event);

	}

	@Override
	public List<GetAllEventsResponse> getAllByCategory(String category) {
		List<GetAllEventsResponse> events = getAll();
		List<GetAllEventsResponse> ourEvents = new ArrayList<GetAllEventsResponse>();
		for (GetAllEventsResponse getAllEventsResponse : events) {
			if(getAllEventsResponse.getSport_category().equals(category)) {
				ourEvents.add(getAllEventsResponse);
			}
		}
		return ourEvents;
	}
	
}
