package com.bookmyshow.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.Repository.AddressRepo;
import com.bookmyshow.entity.Address;

@Repository
public class AddressDAO {
	
	@Autowired
	private AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	public Address updateAddress(long addressId, Address address) {
		Optional<Address> optional = addressRepo.findById(addressId);
		if (optional.isPresent()) {
			address.setAddressID(addressId);
			return addressRepo.save(address);
		}
		return null;
	}
	
	public Address getAddressById(long addressId) {
		Optional<Address> optional = addressRepo.findById(addressId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Address deleteAddress(long addressId) {
		Address dbAddress = getAddressById(addressId);
		if (dbAddress != null) {
			addressRepo.delete(dbAddress);
			return dbAddress;
		}
		return null;
	}

	
}
