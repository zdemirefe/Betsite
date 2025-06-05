package com.Betsite.Betsite.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Betsite.Betsite.business.abstratcs.PaymentService;
import com.Betsite.Betsite.business.requests.CreatePaymentRequest;
import com.Betsite.Betsite.business.responses.GetAllPaymentsResponse;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentsController {
	
	private PaymentService paymentService;
	@Autowired
	public PaymentsController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	@GetMapping
	public List<GetAllPaymentsResponse> getAll()
	{
		return this.paymentService.getAll();
	}
	@PostMapping("/customerId")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(double amount,String payment_type,int customer_id) 
	{
		CreatePaymentRequest createPaymentRequest = new CreatePaymentRequest();
		createPaymentRequest.setPayment_type(payment_type);
		createPaymentRequest.setPayment_amount(amount);
		createPaymentRequest.setCustomer_id(customer_id);
		this.paymentService.add(createPaymentRequest);
	}
	@GetMapping("/customerId")
	public List<GetAllPaymentsResponse> getById(int customer_id)
	{
		return this.paymentService.getById(customer_id);
	}
	
}
