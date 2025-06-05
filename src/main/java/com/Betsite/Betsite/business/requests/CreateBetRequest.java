package com.Betsite.Betsite.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBetRequest {
	private int bet_id;
	private int event_id;
	private float bet_ratio;
	private String bet_type;
}
