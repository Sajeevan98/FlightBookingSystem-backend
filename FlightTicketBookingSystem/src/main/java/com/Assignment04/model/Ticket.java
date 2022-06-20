package com.Assignment04.model;

import javax.persistence.*;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String seatNo;
	private String departure;
	private String arrival;
	private String dateTime;
	private double price;
	@ManyToOne
	private Flight flight;
	
	public Ticket() {
		
	}

	public Ticket(Long id, String seatNo, String departure, String arrival, String dateTime, double price, Flight flight) {
		this.id = id;
		this.seatNo = seatNo;
		this.departure = departure;
		this.arrival = arrival;
		this.dateTime = dateTime;
		this.price = price;
		this.flight = flight;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
