package com.meensat.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.meensat.dto.VendorRegistrationDto;
import com.meensat.model.Vendor;

public interface VendorService extends UserDetailsService {
	
	Vendor saveVendor(VendorRegistrationDto dto);

}
