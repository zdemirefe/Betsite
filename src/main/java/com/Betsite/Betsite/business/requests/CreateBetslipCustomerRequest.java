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
public class CreateBetslipCustomerRequest {
	private int betslipcustomer_id;
	private int betslip_id;
	private int bet_id;
}
