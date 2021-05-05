package com.hubino.upwork.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(BusController.class);

	@RequestMapping("/getBuses")
	public @ResponseBody List<Bus> getAvailableBuses() {
		return busService.getAvailableBuses();
	}

	@RequestMapping("/addBus")
	public void addBus(@RequestBody Bus bus) {

		logger.info("#########Request add a new Bus with details:- " + bus.toString());

		busService.addBus(bus);

	}

	@RequestMapping("/bookBus")
	public String bookBus(@RequestBody BookingPayload bookPayload) {
		logger.info("#########Request to book a Bus with details:- " + bookPayload.toString());

		busService.uploadBookingDetails(bookPayload);

		return "Booking Successfully Completed";
	}
}
