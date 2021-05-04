package com.hubino.upwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubino.upwork.dao.BusRepository;
import com.hubino.upwork.entity.Bus;
@Service
public class BusService {
	
	@Autowired
	BusRepository repository;

	public List<Bus> getAvailableBuses(){
		repository.deleteAll();
		repository.save(new Bus("Mohali", true, "Ludhiana", 20));
		repository.save(new Bus("Chandigarh", true, "Abohar", 4));
		repository.save(new Bus("Sirsa", false, "Abohar", 2));
		repository.save(new Bus("Mohali", false, "Jalandhar", 0));
		
		for(Bus user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println("Buses find with Availability:--------");
		return repository.findByAvailability(true);
	}
}
