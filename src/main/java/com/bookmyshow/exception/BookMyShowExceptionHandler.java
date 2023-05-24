package com.bookmyshow.exception;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class BookMyShowExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new HashMap<>();
		for (ObjectError error : list) {
			String message = error.getDefaultMessage();
			String fieldName = ((FieldError) error).getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
