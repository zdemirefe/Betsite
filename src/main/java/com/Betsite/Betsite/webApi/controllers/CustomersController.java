package com.Betsite.Betsite.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Betsite.Betsite.business.abstratcs.CustomerService;
import com.Betsite.Betsite.business.requests.CreateCustomerRequest;
import com.Betsite.Betsite.business.responses.GetAllCustomersResponse;




@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomersController {
	
	private CustomerService customerService;
	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/getAll")
	public List<GetAllCustomersResponse> getAll()
	{
		return customerService.getAll();
	}
	@PostMapping("/post")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateCustomerRequest createCustomerRequest) 
	{
		this.customerService.add(createCustomerRequest);
	}
	@GetMapping("/getcustomerbyId")
	public GetAllCustomersResponse getCustomerById(int customer_id) 
	{
		return this.customerService.getCustomerById(customer_id);
	}
	@PostMapping("/update")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void update(@RequestBody GetAllCustomersResponse getAllCustomersResponse) 
	{
		this.customerService.update(getAllCustomersResponse);
	}
	
}
