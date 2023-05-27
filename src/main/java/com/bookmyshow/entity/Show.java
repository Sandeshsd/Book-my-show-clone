package com.bookmyshow.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bookmyshow.enums.ShowStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private long showId;
	private LocalTime showStartTime;
	private LocalTime showEndTime;
	private ShowStatus showStatus;
	private long movieId;
	@NotBlank(message = "movieName cannot be blank")
	@NotNull(message = "movieName cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String movieName;
	private String genre;
	private LocalTime movieDuration;
	private String movieDescription;
	@NotBlank(message = "language cannot be blank")
	@NotNull(message = "language cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String language;
	
	private long screenId;
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String screenName;
	
	@Min(1)
	@Max(99999)
	private double premiumSeatPrice;
	@Min(1)
	@Max(99999)
	private double goldSeatPrice;
	@Min(1)
	@Max(99999)
	private double classicSeatPrice;
	
	@OneToMany(mappedBy = "show")
	private List<Tickets> tickets;
	
	@ManyToOne
	@JoinColumn
	private Theatre theatre;
}
