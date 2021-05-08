package com.meensat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meensat.service.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping("/registration")
	public ModelAndView userDashboard() {
		return new ModelAndView("registration");
	}
	
	

}
