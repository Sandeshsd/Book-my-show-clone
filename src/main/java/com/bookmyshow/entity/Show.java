package com.bookmyshow.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bookmyshow.enums.ShowStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Show {

	private long showId;
	private LocalTime showStartTime;
	private LocalTime showEndTime;
	private ShowStatus showStatus;
	
	private double premiumSeatPrice;
	private double goldSeatPrice;
	private double classicSeatPrice;
	
	@OneToMany
	private List<Tickets> tickets;
	
	@ManyToOne
	private Theatre theatre;
}