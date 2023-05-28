package com.bookmyshow.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.OwnerDAO;
import com.bookmyshow.dao.ProductionHouseDAO;
import com.bookmyshow.entity.Owner;
import com.bookmyshow.entity.ProductionHouse;
import com.bookmyshow.exception.OwnerNotFoundByIdException;
import com.bookmyshow.util.responseStructure;

@Service
public class ProductionService {

	
	@Autowired
	private ProductionHouseDAO houseDAO;
	
	@Autowired
	private OwnerDAO ownerDAO;
	
	public ResponseEntity<responseStructure<ProductionHouse>> saveProductionHouse(ProductionHouse house,long ownerId){
		Owner owner=ownerDAO.getOwnerById(ownerId);
		if(owner!=null) {
			house.setEstablismentTime(LocalDateTime.now());
			house=houseDAO.saveProductionHouse(house);
			house.setOwner(owner);
			owner.getProductionHouses().add(house);
			ownerDAO.saveOwner(owner);
			responseStructure<ProductionHouse> responseStructure=new responseStructure<>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("prodctionHouse added successfully");
			responseStructure.setData(house);
			return new ResponseEntity<responseStructure<ProductionHouse>>(responseStructure,HttpStatus.CREATED);
		}
		throw new OwnerNotFoundByIdException("please enter crct Owner id");
	}
}
