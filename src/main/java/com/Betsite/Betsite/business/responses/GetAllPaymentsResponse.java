package com.Betsite.Betsite.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPaymentsResponse {
	private int payment_id;
	private int customer_id;
	private String payment_datetime;
	private double payment_amount;
	private String payment_type;
	private String payment_situation;
}
