package com.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class ProductionHouseNotFoundByIdException extends RuntimeException {

	
	private String message;
}
