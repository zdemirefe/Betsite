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

@Table(name="PAYMENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAYMENT_ID")
	private int payment_id;
	@Column(name="DATE_TIME")
	private String payment_datetime;
	@Column(name="PAYMENT_AMOUNT")
	private double payment_amount;
	@Column(name="PAYMENT_TYPE")
	private String payment_type;
	@Column(name="PAYMENT_SITUATION")
	private String payment_situation;
	@Column(name="CUSTOMER_ID")
	private int customer_id;
	}
