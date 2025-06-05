package com.Betsite.Betsite.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
	private int payment_id;
	private int customer_id;
	private double payment_amount;
	private String payment_type;
}
