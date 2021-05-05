package com.hubino.upwork.entity;

import org.springframework.data.annotation.Id;

public class Bus {
	@Id
	public String id;
	public String source;
	public boolean availability;
	public String destination;
	public int noOfSeatsAvailable;

	public Bus(String source, boolean availability, String destination, int noOfSeatsAvailable) {
		super();
		this.source = source;
		this.availability = availability;
		this.destination = destination;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", source=" + source + ", availability=" + availability + ", destination="
				+ destination + ", noOfSeatsAvailable=" + noOfSeatsAvailable + "]";
	}

}
