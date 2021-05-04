package com.hubino.upwork.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hubino.upwork.entity.Bus;

public interface BusRepository extends MongoRepository<Bus, String>{
	
	public List<Bus> findByAvailability(boolean availability);
}
