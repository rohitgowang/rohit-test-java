package com.hubino.upwork.entity;

import org.springframework.data.annotation.Id;

public class History {
	@Id
	public String id;
	public String userId;
	public String busId;
	public int seats;
	public int price;

	public History(String userId, String busId, int seats, int price) {
		super();
		this.userId = userId;
		this.busId = busId;
		this.seats = seats;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", userId=" + userId + ", busId=" + busId + ", seats=" + seats + ", price=" + price
				+ "]";
	}

}
