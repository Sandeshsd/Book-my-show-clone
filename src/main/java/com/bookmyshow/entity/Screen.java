package com.bookmyshow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bookmyshow.enums.ScreenAvailability;
import com.bookmyshow.enums.ScreenType;
import com.bookmyshow.enums.Screenstatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screenId;
	@NotBlank(message = "screenName cannot be blank")
	@NotNull(message = "screenName cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String screenName;
	
	private ScreenType screenType;
	private ScreenAvailability screenAvailability;
	private Screenstatus screenstatus;
	
	private int numberOfPremiumSeats;
	private int numberOfGoldSeats;
	private int numberOfClassicalSeats;
	
	@OneToMany(mappedBy = "screens")
	private List<Seat> seats;
	
	@ManyToOne
	@JoinColumn
	private Theatre theatre;
	
	
	
}
