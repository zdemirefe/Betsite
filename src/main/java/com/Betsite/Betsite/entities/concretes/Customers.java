package com.Betsite.Betsite.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private int customer_id;
	@Column(name="USER_ID")
	private String user_id;
	@Column(name="CUSTOMER_NAME")
	private String customer_name;
	@Column(name="CUSTOMER_SURNAME")
	private String customer_surname;
	@Column(name="CUSTOMER_MAIL")
	private String customer_mail;
	@Column(name="CUSTOMER_PASSWORD")
	private String customer_password;
	@Column(name="CUSTOMER_DATEOFBIRTH")
	private String customer_date;
	@Column(name="CUSTOMER_GENDER")
	private String customer_gender;
	@Column(name="CUSTOMER_BALANCE")
	private double customer_balance;	
	}
