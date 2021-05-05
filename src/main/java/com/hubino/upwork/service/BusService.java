package com.hubino.upwork.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.Bus;
import com.hubino.upwork.entity.History;
import com.hubino.upwork.entity.UserProfile;
import com.hubino.upwork.repository.BusRepository;
import com.hubino.upwork.repository.HistoryRepository;
import com.hubino.upwork.repository.ProfileRepository;
import com.hubino.upwork.repository.UserRepository;
import com.hubino.upwork.util.BookingPayload;

@Service
public class BusService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(BusService.class);

	public List<Bus> getAvailableBuses() {
		return busRepository.findByAvailability(true);
	}

	public void addBus(Bus bus) {
		busRepository.save(bus);
		logger.info("Bus added Successfully with id:- " + bus.getId());
	}

	public void uploadBookingDetails(BookingPayload bookPayload) {
		Optional<ApplicationUser> user = userRepository.findById(bookPayload.getUserId());
		Optional<Bus> optionalBus = busRepository.findById(bookPayload.getBusId());
		Bus bus = optionalBus.get();
		bus.setNoOfSeatsAvailable(bus.getNoOfSeatsAvailable() - bookPayload.getNoOfSeats());
		logger.info("updating no. of seats in the bus by " + bookPayload.getNoOfSeats());
		UserProfile profile = profileRepository.findByUser(user.get());
		History history = new History(bookPayload.getUserId(), bookPayload.getBusId(), bookPayload.getNoOfSeats(),
				bookPayload.getTicketPrice());
		if (profile.getHistoryList() != null)
			profile.getHistoryList().add(history);
		else {
			List<History> historyList = new ArrayList<History>();
			historyList.add(history);
			profile.setHistoryList(historyList);
		}
		logger.info("updating History document with new Booking:- " + history.toString());
		historyRepository.save(history);
		profileRepository.save(profile);
		busRepository.save(bus);
		logger.info("Booking Added Successfully with id:- " + profile.getId());
	}
}
