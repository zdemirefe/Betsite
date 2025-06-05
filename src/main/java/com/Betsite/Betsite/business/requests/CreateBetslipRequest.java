package com.Betsite.Betsite.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBetslipRequest {
	private int betslip_id;
	private int customer_id;
	private double total_ratio;
	private double betslip_amount;
	private String betslip_situation;
}
