package com.bookmyshow.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.CustomerDAO;
import com.bookmyshow.dto.CustomerDTO;
import com.bookmyshow.entity.Customer;
import com.bookmyshow.exception.CustomerNotFoundByIdException;
import com.bookmyshow.util.responseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<responseStructure<CustomerDTO>> saveCustomer(Customer customer){
		
		customer=customerDAO.saveCustomer(customer);
		CustomerDTO dto=this.modelMapper.map(customer, CustomerDTO.class);
		
		responseStructure<CustomerDTO> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succussefully created customer");
		responseStructure.setData(dto);
        return new ResponseEntity<responseStructure<CustomerDTO>>(responseStructure,HttpStatus.CREATED);		
	}
	public ResponseEntity<responseStructure<CustomerDTO>> getCustomer(long customerId){
	Customer customer=customerDAO.getCustomerById(customerId);
		if(customer!=null) {
			
			CustomerDTO dto=this.modelMapper.map(customer, CustomerDTO.class);
			
			responseStructure<CustomerDTO> responseStructure=new responseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("succussefully created customer");
			responseStructure.setData(dto);
	        return new ResponseEntity<responseStructure<CustomerDTO>>(responseStructure,HttpStatus.OK);	
		}
		throw new CustomerNotFoundByIdException("please enter correct customer id");
	}
	public ResponseEntity<responseStructure<CustomerDTO>> updateCustomer( Customer customer, long customerId) {
		Customer customer2=customerDAO.updateCustomer(customer, customerId);
		if(customer2!=null) {
			
			CustomerDTO dto=this.modelMapper.map(customer, CustomerDTO.class);
			responseStructure<CustomerDTO> responseStructure=new responseStructure<>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("customer updated succussefully ");
			responseStructure.setData(dto);
	        return new ResponseEntity<responseStructure<CustomerDTO>>(responseStructure,HttpStatus.OK);	
		}
		throw new CustomerNotFoundByIdException("please enter correct customer id");
	}
	}

