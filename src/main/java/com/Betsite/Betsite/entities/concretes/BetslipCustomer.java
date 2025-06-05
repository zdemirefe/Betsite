package com.Betsite.Betsite.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="BETSLIP_CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BetslipCustomer {
	@Id
	@Column(name="BETSLIPCUSTOMER_ID")
	private int betslipcustomer_id;
	@Column(name="BETSLIP_ID")
	private int betslip_id;
	@Column(name="BET_ID")
	private int bet_id;
}
