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

@Table(name="STATISTICS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Statistics {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATISTICS_ID")
	private int statistics_id;
	@Column(name="TOTAL_LOSS")
	private double total_loss;
	@Column(name="TOTAL_EARNING")
	private double total_earning;
	@Column(name="WINRATE")
	private float winrate;
	@Column(name="CUSTOMER_ID")
	private int customer_id;
	
}
