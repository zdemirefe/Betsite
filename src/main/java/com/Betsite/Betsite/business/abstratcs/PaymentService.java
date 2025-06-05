package com.Betsite.Betsite.business.abstratcs;

import java.util.List;

import com.Betsite.Betsite.business.requests.CreatePaymentRequest;
import com.Betsite.Betsite.business.responses.GetAllPaymentsResponse;

public interface PaymentService {
	List<GetAllPaymentsResponse> getAll();
	void add(CreatePaymentRequest createPaymentRequest);
	List<GetAllPaymentsResponse> getById(int CUSTOMER_ID);
}
