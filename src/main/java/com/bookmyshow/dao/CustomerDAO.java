package com.bookmyshow.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.Repository.CustomerRepo;
import com.bookmyshow.entity.Customer;

@Repository
public class CustomerDAO {

	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public Customer getCustomerById(long customerId) {
	Optional<Customer> optional	 =customerRepo.findById(customerId);
		if(optional.isEmpty()){
			return null;
		}
			return optional.get();
	}
	public Customer updateCustomer(Customer customer,long customerId) {
		Optional<Customer> optional=customerRepo.findById(customerId);
		if(optional.isEmpty()) {
			return null;
		}
		customer.setCustomerId(customerId);
		return customerRepo.save(customer);
	}
}
