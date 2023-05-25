package com.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	
	private long customerId;
	private String customerName;
	private String customerEmail;
	private long customerPhoneNumber; 

}
