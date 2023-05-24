package com.bookmyshow.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private long ownerId;
	private String ownerName;
	private String ownerEmail;
	private String ownerPassword;
	private long ownerPhoneNumber;
	
	@OneToMany
	private List<ProductionHouse> productionHouses;
}
