package com.hubino.upwork.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Object> getAvailableBuses() {

		List<Bus> buses = busService.getAvailableBuses();
		if (buses != null) {
			return new ResponseEntity<>(buses, HttpStatus.FOUND);
		}
		logger.error("No available bus found for this route");
		return new ResponseEntity<>("No available bus found", HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/addBus")
	public ResponseEntity<Object> addBus(@RequestBody Bus bus) {

		logger.info("#########Request add a new Bus with details:- " + bus.toString());

		Bus savedBus = busService.addBus(bus);
		if (savedBus != null) {
			logger.info("Bus added Successfully with id:- " + savedBus.getId());
			return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
		}
		logger.error("error while saving bus.");
		return new ResponseEntity<>("Unable to add new bus", HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping("/bookBus")
	public ResponseEntity<Object> bookBus(@RequestBody BookingPayload bookPayload) {
		logger.info("#########Request to book a Bus with details:- " + bookPayload.toString());

		return busService.uploadBookingDetails(bookPayload);
	}
}
