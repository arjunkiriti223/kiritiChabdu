package com.meensat.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meensat.dto.VendorRegistrationDto;
import com.meensat.model.Role;
import com.meensat.model.Vendor;
import com.meensat.repository.vendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	
	private vendorRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	 public VendorServiceImpl(vendorRepository repo) {
		 super();
		 this.repo=repo;
	 	}

	@Override
	public Vendor saveVendor(VendorRegistrationDto dto) {
		
		Vendor vendor=new Vendor(dto.getEmailId(),
									dto.getPhoneNumber(),
									dto.getLocation(),
									dto.getAddress(),
									dto.getDialog(),
									dto.getImage(),
									dto.getShopName(),
									dto.isShopOpen(),
									dto.isTopPicked(),
									dto.getRating(),
									dto.isAccVerified(),
									dto.getTotalRating(),
									dto.getRole()
									);
		
		
		return repo.save(vendor);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			Vendor vendor=repo.findByEmail(username);
			if(vendor==null) {
				throw new UsernameNotFoundException("vendor not exitsted...!");
			}
			return null;
			
		/*
		 * return new org.springframework.security.core.userdetails.User
		 * (vendor.getEmailId(),username,mapRolesToAuthorities(vendor.getRole()));
		 */
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
			
			return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	

}
