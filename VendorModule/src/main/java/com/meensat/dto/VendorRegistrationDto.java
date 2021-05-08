package com.meensat.dto;

import com.meensat.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorRegistrationDto {

	private String emailId;

	private Long phoneNumber;

	private Double location;

	private String address;

	private String dialog;

	private byte[] image;

	private String shopName;

	private boolean shopOpen;

	private boolean isTopPicked;

	private int rating;

	private boolean accVerified;

	private int totalRating;
	
	private Role role;
}
