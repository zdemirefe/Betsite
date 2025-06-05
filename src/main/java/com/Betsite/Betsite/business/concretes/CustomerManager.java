package com.Betsite.Betsite.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.CustomerService;
import com.Betsite.Betsite.business.requests.CreateCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllCustomersResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.CustomersDAO;
import com.Betsite.Betsite.entities.concretes.Customers;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService{
	
	private CustomersDAO customersDAO;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllCustomersResponse> getAll() {
		List<Customers> customers = customersDAO.findAll();
		List<GetAllCustomersResponse> customersResponse = customers.stream().map(Customers->this.modelMapperService.forResponse().map(Customers,GetAllCustomersResponse.class)).collect(Collectors.toList());
		return customersResponse;
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customers customer = modelMapperService.forRequest().map(createCustomerRequest, Customers.class);
		customer.setCustomer_balance(0);
		this.customersDAO.save(customer);
	}

	@Override
	public void update(GetAllCustomersResponse getAllCustomersResponse) {
		Customers customer = modelMapperService.forRequest().map(getAllCustomersResponse, Customers.class);
		this.customersDAO.save(customer);
	}

	@Override
	public GetAllCustomersResponse getCustomerById(int customer_id) {
		List<GetAllCustomersResponse> customers = getAll();
		GetAllCustomersResponse getAllCustomersResponse = new GetAllCustomersResponse();
		for (GetAllCustomersResponse customer : customers) {
			if(customer.getCustomer_id()==customer_id) 
			{
				getAllCustomersResponse=customer;
			}
		}
		return getAllCustomersResponse;
	}
	
	
	
}
