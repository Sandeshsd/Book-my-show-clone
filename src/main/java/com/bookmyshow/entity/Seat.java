package com.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bookmyshow.enums.SeatType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {

	@Id
	private long seatId;
	private SeatType seatType;
	
	
	@ManyToOne
	private Screen screen;
	
}
