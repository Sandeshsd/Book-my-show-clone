package com.bookmyshow.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class CustomerNotFoundByIdException extends RuntimeException {

 private String message;
}
