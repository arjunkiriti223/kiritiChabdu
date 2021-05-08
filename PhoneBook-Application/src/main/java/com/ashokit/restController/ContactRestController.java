package com.ashokit.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.ContactEntity;
import com.ashokit.service.impl.ContactServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
	//
	 Logger logger= LoggerFactory.getLogger(ContactRestController.class);
	
	private ContactServiceImpl contactService;


	public void setContactService(ContactServiceImpl contactService) {
		this.contactService = contactService;
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveContact(@RequestBody ContactEntity contact){
		
		boolean status=contactService.saveContact(contact);
		if(status) {
			return new ResponseEntity<>("Contact saved..!",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Contact not saved..!",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<ContactEntity>> getAllContacts() {
		
		
		List<ContactEntity> contactList=contactService.getAllContacts();
		
		if(contactList!=null) {
			return new ResponseEntity<List<ContactEntity>>(contactList,HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/{contactId}")
	public ResponseEntity<ContactEntity> getContactById(@PathVariable(name="contactId") Integer contactId){
		ContactEntity contact=contactService.getContactById(contactId);
		if(contact!=null) {
			return new ResponseEntity<>(contact,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer contactId){
		ContactEntity contact=contactService.getContactById(contactId);
		if(contact!=null) {
			return new ResponseEntity<>("deleted succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("failed to delete the contact",HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PostMapping
	public ResponseEntity<String> saveContact23(@RequestBody ContactEntity contact){
		
		logger.debug("methode execution satred-saveContact23()");
		Integer id=contactService.saveContact2(contact);
		if(id!=0)
			return new ResponseEntity<String>("Contact Saved with Id ="+id,HttpStatus.CREATED);
		else
		return null;
		
	}
	
	

}
