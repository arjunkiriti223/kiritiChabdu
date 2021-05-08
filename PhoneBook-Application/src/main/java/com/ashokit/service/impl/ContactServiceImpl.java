package com.ashokit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashokit.entity.ContactEntity;
import com.ashokit.repo.IContactRepo;
import com.ashokit.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {
	
	private IContactRepo contactRepo;
	
	public ContactServiceImpl(IContactRepo contactRepo) {
		this.contactRepo=contactRepo;
	}

	@Override
	public boolean saveContact(ContactEntity contact) {
		ContactEntity status=contactRepo.save(contact);
		return status.getContact_Id()!=null?true:false;
		/*
		 * if(status!=null) { return true; } else { return false; }
		 */
		//return status.getContact_Id()!=null;
		
		
	}

	@Override
	public ContactEntity getContactById(Integer id) {
			
		Optional<ContactEntity> optional=contactRepo.findById(id);
		
		if(optional.isPresent()) {
		return optional.get();
		}
		
		return null;
	}

	@Override
	public List<ContactEntity> getAllContacts() {
		List<ContactEntity> allContacts=contactRepo.findAll();
		
		return allContacts;
	}

	@Override
	public boolean deleteContactById(Integer id) {
		try {
			contactRepo.deleteById(id);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public int saveContact2(ContactEntity contact) {
		ContactEntity saved=contactRepo.save(contact);
		
		
		return saved.getContact_Id();
	}

}
