package com.bookmyshow.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyshow.dto.OwnerDTO;
import com.bookmyshow.entity.Owner;
import com.bookmyshow.service.OwnerService;
import com.bookmyshow.util.responseStructure;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping
	public ResponseEntity<responseStructure<OwnerDTO>> saveOwner(@Valid @RequestBody Owner owner){
		return ownerService.saveOwner(owner);
	}
	@GetMapping
	public ResponseEntity<responseStructure<OwnerDTO>> getownerById(@RequestBody Owner owner,@RequestParam long ownerId){
		return ownerService.getOwnerById(owner, ownerId);
	}
}
