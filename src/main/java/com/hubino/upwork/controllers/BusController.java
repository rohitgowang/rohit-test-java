package com.hubino.upwork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.upwork.entity.Bus;
import com.hubino.upwork.service.BusService;
import com.hubino.upwork.util.BookingPayload;

@RestController
public class BusController {

	@Autowired
	BusService busService;

	@RequestMapping("/getBuses")
	public @ResponseBody List<Bus> getAvailableBuses() {
		return busService.getAvailableBuses();
	}

	@RequestMapping("/bookBus")
	public String bookBus(@RequestBody BookingPayload bookPayload) {
		busService.uploadBookingDetails(bookPayload);
		return "Booking Successfully Completed";
	}
}
