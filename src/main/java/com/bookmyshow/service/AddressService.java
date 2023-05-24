package com.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.AddressDAO;
import com.bookmyshow.entity.Address;
import com.bookmyshow.util.responseStructure;

@Service
public class AddressService {

	
	@Autowired
	private AddressDAO addressDAO;
	
	public ResponseEntity<responseStructure<Address>> saveAdress(Address address ){
		Address address2=addressDAO.saveAddress(address);
		responseStructure<Address> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Address added succussfully");
		responseStructure.setData(address2);
		return new ResponseEntity<responseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}
}
