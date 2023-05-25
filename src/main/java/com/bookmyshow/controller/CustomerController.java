package com.bookmyshow.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dto.CustomerDTO;
import com.bookmyshow.entity.Customer;
import com.bookmyshow.service.CustomerService;
import com.bookmyshow.util.responseStructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@PostMapping
	public ResponseEntity<responseStructure<CustomerDTO>> saveCustomer(@Valid @RequestBody Customer customer){
		return customerService.saveCustomer(customer);
	}
	@GetMapping
	public ResponseEntity<responseStructure<CustomerDTO>> getCustomerById(@RequestParam long customerId){
		return customerService.getCustomer(customerId);
	}
	@PutMapping
	public ResponseEntity<responseStructure<CustomerDTO>> upadteCustomer(@Valid @RequestBody Customer customer,@RequestParam long customerId){
		return customerService.updateCustomer(customer,customerId);
	}
}
