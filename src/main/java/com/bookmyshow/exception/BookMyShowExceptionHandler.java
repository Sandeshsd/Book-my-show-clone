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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookmyshow.util.responseStructure;

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
	
	@ExceptionHandler
	public ResponseEntity<responseStructure<String>> CustomerNotFoundById(CustomerNotFoundByIdException ex){
		responseStructure<String> structure = new responseStructure<>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setData("Customer not found with the requested Id!!");
		return new ResponseEntity<responseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
   @ExceptionHandler
   public ResponseEntity<responseStructure<String>> movieNotFoundById(MovieNotFoundByIdException ex){
	   responseStructure<String> structure=new responseStructure<>();
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   structure.setMessage(ex.getMessage());
	   structure.setData("customer not found with the id");
	   return new ResponseEntity<responseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler
   public ResponseEntity<responseStructure<String>> ownerNotFoundById(OwnerNotFoundByIdException ex){
	   responseStructure<String> structure=new responseStructure<>();
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   structure.setMessage(ex.getMessage());
	   structure.setData("owner not found with the id");
	   return new ResponseEntity<responseStructure<String>>(structure,HttpStatus.NOT_FOUND);
   }
 
   public ResponseEntity<responseStructure<String>> productionHouseNotFoundById(ProductionHouseNotFoundByIdException e){
	   responseStructure<String> responseStructure=new responseStructure<>();
	   responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   responseStructure.setMessage(e.getMessage());
	   responseStructure.setData("production house not found");
	   return new ResponseEntity<responseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
   }
}
