package com.bookmyshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.entity.ProductionHouse;

public interface ProductionRepo extends JpaRepository<ProductionHouse, Long>{

}
