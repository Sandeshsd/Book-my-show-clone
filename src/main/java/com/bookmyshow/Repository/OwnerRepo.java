package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Long> {

}
