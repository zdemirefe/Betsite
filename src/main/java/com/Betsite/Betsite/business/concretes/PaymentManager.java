package com.Betsite.Betsite.business.concretes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Betsite.Betsite.business.abstratcs.PaymentService;
import com.Betsite.Betsite.business.requests.CreatePaymentRequest;
import com.Betsite.Betsite.business.responses.GetAllPaymentsResponse;
import com.Betsite.Betsite.common.utilities.mappers.ModelMapperService;
import com.Betsite.Betsite.dataAccess.abstracts.PaymentsDAO;
import com.Betsite.Betsite.entities.concretes.Payments;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService{
	
	private PaymentsDAO paymentDAO;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllPaymentsResponse> getAll() {
		List<Payments> payments = paymentDAO.findAll();
		List<GetAllPaymentsResponse> paymentsResponse = payments.stream().map(Payment->this.modelMapperService.forResponse().map(Payment,GetAllPaymentsResponse.class)).collect(Collectors.toList());
		return paymentsResponse;
	}

	@Override
	public void add(CreatePaymentRequest createPaymentRequest) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
		Payments payment = this.modelMapperService.forRequest().map(createPaymentRequest,Payments.class);
		payment.setPayment_datetime(formattedDateTime);
		payment.setPayment_situation("Waiting");
		this.paymentDAO.save(payment);
	}

	@Override
	public List<GetAllPaymentsResponse> getById(int CUSTOMER_ID) {
		List<GetAllPaymentsResponse> getAllPaymentsResponses = getAll();
		List<GetAllPaymentsResponse> ourPaymentsResponses = new ArrayList<GetAllPaymentsResponse>();
		for (GetAllPaymentsResponse getAllPaymentsResponse : getAllPaymentsResponses) {
			if(CUSTOMER_ID==getAllPaymentsResponse.getCustomer_id()) 
			{
				ourPaymentsResponses.add(getAllPaymentsResponse);
			}
		}
		return ourPaymentsResponses;
	}
	
}
