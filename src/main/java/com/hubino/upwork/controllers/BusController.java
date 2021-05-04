package com.hubino.upwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hubino.upwork.service.BusService;

@RestController
public class BusController {
	
	@Autowired
	BusService busService;
	@RequestMapping("/getBuses")
	public String getAvailableBuses() {
		System.out.println(busService.getAvailableBuses());
		return "available buses";
	}
}
