package com.hubino.upwork.util;

public class BookingPayload {
	private String userId;
	private String username;
	private String busId;
	private int ticketPrice;
	private int noOfSeats;
	private String sourceStop;
	private String destinationStop;

	public BookingPayload() {
	}

	public BookingPayload(String userId, String username, String busName, int ticketPrice, int noOfSeats,
			String sourceStop, String destinationStop) {
		this.userId = userId;
		this.username = username;
		this.busId = busId;
		this.ticketPrice = ticketPrice;
		this.noOfSeats = noOfSeats;
		this.sourceStop = sourceStop;
		this.destinationStop = destinationStop;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSourceStop() {
		return sourceStop;
	}

	public void setSourceStop(String sourceStop) {
		this.sourceStop = sourceStop;
	}

	public String getDestinationStop() {
		return destinationStop;
	}

	public void setDestinationStop(String destinationStop) {
		this.destinationStop = destinationStop;
	}

	@Override
	public String toString() {
		return "BookingPayload [username=" + username + ", busId=" + busId + ", ticketPrice=" + ticketPrice
				+ ", noOfSeats=" + noOfSeats + ", sourceStop=" + sourceStop + ", destinationStop=" + destinationStop
				+ "]";
	}

}
