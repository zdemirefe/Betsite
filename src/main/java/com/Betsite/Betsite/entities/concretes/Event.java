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

@Table(name="MY_EVENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EVENT_ID")
	private int event_id;
	@Column(name="START_TIME")
	private String start_time;
	@Column(name="FINAL_TIME")
	private String final_time;
	@Column(name="SPORT_CATEGORY")
	private String sport_category;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="HOME")
	private String home;
	@Column(name="AWAY")
	private String away;
	}
