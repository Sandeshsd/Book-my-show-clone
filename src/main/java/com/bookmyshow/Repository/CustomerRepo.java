package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
