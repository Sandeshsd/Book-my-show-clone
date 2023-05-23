package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
