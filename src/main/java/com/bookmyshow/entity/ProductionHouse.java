package com.bookmyshow.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductionHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productionId;
	@NotBlank(message = "ProductionName cannot be blank")
	@NotNull(message = "ProductionName cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String productionName;
	private LocalDateTime establismentTime;
	
	@OneToMany(mappedBy = "productionHouse",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Movie> movies;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Owner owner;
	
}
