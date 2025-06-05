package com.Betsite.Betsite.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatisticRequest {
	private int statistic_id;
	private int customer_id;
	private double total_loss;
	private double total_earning;
	private float winrate;
}
