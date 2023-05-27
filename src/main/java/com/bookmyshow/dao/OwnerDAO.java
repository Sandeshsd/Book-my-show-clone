package com.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.Repository.OwnerRepo;
import com.bookmyshow.entity.Owner;

@Repository
public class OwnerDAO {

	@Autowired
	private OwnerRepo ownerRepo;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	public Owner getOwnerById(long ownerId) {
		Optional<Owner> optional=ownerRepo.findById(ownerId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public Owner updateOwner(Owner owner,long ownerId) {
		Optional<Owner> optional=ownerRepo.findById(ownerId);
		if(optional.isEmpty()) {
			return null;
		}
		owner.setOwnerId(ownerId);
		return ownerRepo.save(owner);
	}
	public Owner deleteOwner(long ownerId) {
		Optional< Owner> optional=ownerRepo.findById(ownerId);
		if(optional.isEmpty()) {
			return null;
		}
		ownerRepo.delete(optional.get());
		return optional.get();
	}
}
