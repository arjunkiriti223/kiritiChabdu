package com.meensat.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
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
	
	//@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	/*
	 * @JoinTable( name = "users_roles", joinColumns = @JoinColumn( name =
	 * "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
	 * name = "role_id", referencedColumnName = "id")) private Collection<Role>
	 * role;
	 */
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "vr_id")
	private Role role;

	public Vendor(String emailId, Long phoneNumber, Double location, String address, String dialog, byte[] image,
			String shopName, boolean shopOpen, boolean isTopPicked, int rating, boolean accVerified, int totalRating,Role role) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.address = address;
		this.dialog = dialog;
		this.image = image;
		this.shopName = shopName;
		this.shopOpen = shopOpen;
		this.isTopPicked = isTopPicked;
		this.rating = rating;
		this.accVerified = accVerified;
		this.totalRating = totalRating;
		this.role=role;
		
	}
	
	
	
	
}
