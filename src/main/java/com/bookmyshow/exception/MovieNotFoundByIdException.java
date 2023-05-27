package com.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class MovieNotFoundByIdException extends RuntimeException {

	private String message;
}
