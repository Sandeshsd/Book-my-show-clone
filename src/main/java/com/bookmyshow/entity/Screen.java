package com.bookmyshow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screenId;
	private String screenName;
	private int numberOfPremiumSeats;
	private int numberOfGoldSeats;
	private int numberOfClassicalSeats;
	
	@OneToMany
	private List<Seat> seats;
	
	@ManyToOne
	private Theatre theatre;
	
	
	
}
