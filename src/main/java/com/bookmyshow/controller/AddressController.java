package com.bookmyshow.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.Address;
import com.bookmyshow.service.AddressService;
import com.bookmyshow.util.responseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<responseStructure<Address>> saveAddress(@Valid @RequestBody Address address){
		return addressService.saveAdress(address);
	}
}
