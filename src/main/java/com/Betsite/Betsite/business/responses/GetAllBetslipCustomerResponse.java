package com.Betsite.Betsite.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBetslipCustomerResponse {
	private int betslipcustomer_id;
	private int betslip_id;
	private int bet_id;
}
