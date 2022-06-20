package com.Assignment04.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Flight {
	
	@Id
	private String id;
	private String name;	
	private double capacity;
	private String airlines;
	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets;
	
	public Flight() {

	}

	public Flight(String id, String name, double capacity, String airlines) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.airlines = airlines;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	
}
