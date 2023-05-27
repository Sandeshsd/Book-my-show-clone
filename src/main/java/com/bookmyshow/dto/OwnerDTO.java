package com.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerDTO {

	private long ownerId;
	private String ownerName;
	private long ownerPhoneNumber;
	private String ownerEmail;
}
