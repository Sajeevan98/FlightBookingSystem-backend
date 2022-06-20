package com.Assignment04.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Assignment04.model.Passenger;

public interface PassengerService {

	public List<Passenger> getAllPassenger();
	public Passenger addPassenger(Passenger pModel);
	public Optional<Passenger> updatePassenger(long id, Passenger pModel);
	public ResponseEntity<Map<String, Boolean>> deletePassenger(long id);
	


}
