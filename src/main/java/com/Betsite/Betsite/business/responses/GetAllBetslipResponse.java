package com.Betsite.Betsite.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBetslipResponse {
	private int betslip_id;
	private int customer_id;
	private double total_ratio;
	private double betslip_amount;
	private String betslip_situation;
}
