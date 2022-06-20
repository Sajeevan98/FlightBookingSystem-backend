package com.Assignment04.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Assignment04.model.Flight;
import com.Assignment04.model.Ticket;

public interface FlightService {

	public List<Flight> getAll();
	public Optional<Flight> getById(String id);
	public List<Ticket> getTicketByFlight(String id);
	public Flight  addFlight(Flight fModel);
	public Optional<Flight> updateFlight(String id, Flight fModel);
	public ResponseEntity<Map<String, Boolean>> deleteById(String id);
}
