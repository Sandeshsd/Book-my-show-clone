package com.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.entity.ProductionHouse;
import com.bookmyshow.service.ProductionService;
import com.bookmyshow.util.responseStructure;

@RestController
@RequestMapping("/production")
public class ProductionController {

	@Autowired
	private ProductionService productionService;
	
	@PostMapping
	public ResponseEntity<responseStructure<ProductionHouse>> saveProductionHouse(@RequestBody ProductionHouse productionHouse,@RequestParam long ownerId){
		return productionService.saveProductionHouse(productionHouse,ownerId);
	}
}
