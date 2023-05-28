package com.bookmyshow.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.bookmyshow.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long movieId;
	@NotBlank(message="movie name can not be null")
	@NotNull(message = "movie name can not be blanck")
	private String movieName;
	@DateTimeFormat(style = "hh:mm")
	private LocalDateTime movieDuration;
	private Genre genre1;
	private Genre genre2;
	private Genre genre3;
	private String movieDescription;
	@NotBlank(message = "Movie cannot be blank")
	@NotNull(message = "Movie cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String langauge;
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private ProductionHouse productionHouse;
}
