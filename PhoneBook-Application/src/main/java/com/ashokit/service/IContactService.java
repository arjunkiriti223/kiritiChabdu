package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.ContactEntity;


public interface IContactService {
	
	public boolean saveContact(ContactEntity contact);
	
	
	public int saveContact2(ContactEntity contact);
	
	public ContactEntity getContactById(Integer id);
	
	public List<ContactEntity> getAllContacts();
	
	public boolean deleteContactById(Integer id);

}
