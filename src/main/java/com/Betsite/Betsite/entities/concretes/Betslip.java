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

@Table(name="BETSLIP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Betslip {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BETSLIP_ID")
	private int betslip_id;
	@Column(name="TOTAL_RATIO")
	private double total_ratio;
	@Column(name="BETSLIP_AMOUNT")
	private double betslip_amount;
	@Column(name="BETSLIP_SITUATION")
	private String betslip_situation;
	@Column(name="CUSTOMER_ID")
	private int customer_id;
}
