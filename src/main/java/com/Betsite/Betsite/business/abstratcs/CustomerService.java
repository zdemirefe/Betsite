package com.Betsite.Betsite.business.abstratcs;

import java.util.List;

import com.Betsite.Betsite.business.requests.CreateCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllCustomersResponse;

public interface CustomerService {
	List<GetAllCustomersResponse> getAll();
	void add(CreateCustomerRequest createCustomerRequest);
	void update(GetAllCustomersResponse getAllCustomersResponse);
	GetAllCustomersResponse getCustomerById(int customer_id);
}
