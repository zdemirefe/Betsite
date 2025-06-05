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

@Table(name="BETS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Bets {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BET_ID")
	private int bet_id;
	@Column(name="BET_RATIO")
	private float bet_ratio;
	@Column(name="BET_TYPE")
	private String bet_type;
	@Column(name="EVENT_ID")
	private int event_id;
}
