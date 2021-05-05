package com.hubino.upwork.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.BusRepository;
import com.hubino.upwork.dao.HistoryRepository;
import com.hubino.upwork.dao.ProfileRepository;
import com.hubino.upwork.dao.UserRepository;
import com.hubino.upwork.entity.ApplicationUser;
import com.hubino.upwork.entity.Bus;
import com.hubino.upwork.entity.History;
import com.hubino.upwork.entity.UserProfile;
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

	public List<Bus> getAvailableBuses() {
		return busRepository.findByAvailability(true);
	}

	public void uploadBookingDetails(BookingPayload bookPayload) {
		Optional<ApplicationUser> user = userRepository.findById(bookPayload.getUserId());
		Optional<Bus> optionalBus = busRepository.findById(bookPayload.getBusId());
		Bus bus = optionalBus.get();
		bus.setNoOfSeatsAvailable(bus.getNoOfSeatsAvailable() - bookPayload.getNoOfSeats());
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
		historyRepository.save(history);
		profileRepository.save(profile);
		busRepository.save(bus);
	}
}
