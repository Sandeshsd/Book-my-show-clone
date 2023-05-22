package com.bookmyshow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private long addressID;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String state;
	private String country;
	
	@OneToOne
	private Theatre theatre;
}
