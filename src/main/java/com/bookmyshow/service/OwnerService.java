package com.bookmyshow.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.dao.OwnerDAO;
import com.bookmyshow.dto.OwnerDTO;
import com.bookmyshow.entity.Owner;
import com.bookmyshow.exception.OwnerNotFoundByIdException;
import com.bookmyshow.util.responseStructure;

@Service
public class OwnerService {

	@Autowired
	private OwnerDAO ownerDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseEntity<responseStructure<OwnerDTO>> saveOwner(Owner owner){
		owner=ownerDAO.saveOwner(owner);
		OwnerDTO dto=this.modelMapper.map(owner, OwnerDTO.class);
		
		responseStructure<OwnerDTO> responseStructure=new responseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("owner added succussfully");
		responseStructure.setData(dto);
		return new ResponseEntity<responseStructure<OwnerDTO>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<responseStructure<OwnerDTO>> getOwnerById(Owner owner,long ownerId){
		owner=ownerDAO.getOwnerById(ownerId);
		if(owner!=null) {
			OwnerDTO dto=this.modelMapper.map(owner, OwnerDTO.class);
			responseStructure<OwnerDTO> responseStructure=new responseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("owner found succussfully");
			responseStructure.setData(dto);
			return new ResponseEntity<responseStructure<OwnerDTO>>(responseStructure,HttpStatus.FOUND);
		}
		throw new OwnerNotFoundByIdException("Plz enter correct owner id");
	}
}
