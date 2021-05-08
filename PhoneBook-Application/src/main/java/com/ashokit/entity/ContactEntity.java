package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Contact_dtls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactEntity {
	@Id
	@GeneratedValue
	private Integer contact_Id;
	private String contact_Name;
	private String contact_Mail;
	private long contact_Number;

}
