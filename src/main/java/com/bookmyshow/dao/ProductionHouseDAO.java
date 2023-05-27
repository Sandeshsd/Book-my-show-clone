package com.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.Repository.ProductionRepo;
import com.bookmyshow.entity.ProductionHouse;
@Repository
public class ProductionHouseDAO {
	
	@Autowired
	private ProductionRepo productionRepo;

	public ProductionHouse saveProductionHouse(ProductionHouse productionHouse) {
		return productionRepo.save(productionHouse);
	}
	
	public ProductionHouse getProductionHouseById(long productionId) {
		Optional<ProductionHouse> optional=productionRepo.findById(productionId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public ProductionHouse updateProductionHouse(ProductionHouse house,long productionId) {
		Optional<ProductionHouse> optional=productionRepo.findById(productionId);
		if(optional.isEmpty()) {
			return null;
		}
		house.setProductionId(productionId);
		return productionRepo.save(house);
	}
	public ProductionHouse deleteProductionHouse(long productionId) {
		Optional<ProductionHouse> optional=productionRepo.findById(productionId);
		if(optional.isEmpty()) {
			return null;
		}
		ProductionHouse house=optional.get();
		productionRepo.delete(house);
	    return optional.get();
	}

}
