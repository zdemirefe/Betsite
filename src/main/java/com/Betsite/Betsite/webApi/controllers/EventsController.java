package com.Betsite.Betsite.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Betsite.Betsite.business.abstratcs.EventService;
import com.Betsite.Betsite.business.requests.CreateEventRequest;
import com.Betsite.Betsite.business.responses.GetAllEventsResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventsController {

	private EventService eventService;
	@Autowired
	public EventsController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	@GetMapping("/getAll")
	public List<GetAllEventsResponse> getAll()
	{
		return this.eventService.getAll();
	}
	@PostMapping("/post")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateEventRequest createEventRequest) 
	{
		this.eventService.add(createEventRequest);
	}
	@GetMapping("/getByCategory")
	public List<GetAllEventsResponse> getAllByCategory(String category)
	{
		return this.eventService.getAllByCategory(category);
	}
	
}
