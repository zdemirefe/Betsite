package com.Betsite.Betsite.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEventsResponse {
	private int event_id;
	private String start_time;
	private String final_time;
	private String sport_category;
	private String country;
	private String home;
	private String away;
}
