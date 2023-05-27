package com.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private long addressID;
	@NotBlank (message = "AddressLine1 cannot be blank")
	@NotNull(message = "Address cannot be null")
	private String addressLine1;
	@NotBlank (message = "AddressLine2 cannot be blank")
	@NotNull(message = "Address cannot be null")
	private String addressLine2;
	private String addressLine3;
	@NotBlank (message = "Address cannot be blank")
	@NotNull(message = "Address cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String state;
	@NotBlank(message = "Address cannot be blank")
	@NotNull(message = "Address cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Name should Start with capital letter")
	private String country;
	
	@OneToOne(mappedBy = "address")
	private Theatre theatre;
}
