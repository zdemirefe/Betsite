package com.Betsite.Betsite.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomersResponse {
	private int customer_id;
	private String user_id;
	private String customer_name;
	private String customer_surname;
	private String customer_mail;
	private String customer_password;
	private String customer_date;
	private String customer_gender;
	private double customer_balance;
	}

