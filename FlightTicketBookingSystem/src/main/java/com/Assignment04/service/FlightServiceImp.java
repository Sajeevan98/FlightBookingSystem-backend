package com.Assignment04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Assignment04.exception.ResourceNotFoundException;
import com.Assignment04.model.Flight;
import com.Assignment04.model.Ticket;
import com.Assignment04.repository.FlightRepository;

@Service
public class FlightServiceImp implements FlightService{

	@Autowired
	private FlightRepository fRepository;
	
	@Override
	public List<Flight> getAll() {
		
		return fRepository.findAll();
	}

	@Override
	public Optional<Flight> getById(String id) {
		Flight objFlight = fRepository.findById(id).orElseThrow(
				
					()-> new ResourceNotFoundException("Flight not exit with Id: "+ id)
				);		
		return Optional.ofNullable(objFlight);
	}
	
	@Override
	public List<Ticket> getTicketByFlight(String id) {
		
		return fRepository.getTicketByFlightId(id);
	}

	@Override
	public Flight addFlight(Flight fModel) {
		
		return fRepository.save(fModel);
	}

	@Override
	public Optional<Flight> updateFlight(String id, Flight fModel) {
		Flight objFlight = fRepository.findById(id).orElseThrow(
				
					()-> new ResourceNotFoundException("Ticket not reserved with this flight-Id: "+ id)
				);
		objFlight.setId(fModel.getId());
		objFlight.setName(fModel.getName());
		objFlight.setAirlines(fModel.getAirlines());
		objFlight.setCapacity(fModel.getCapacity());
		
		return Optional.ofNullable(fRepository.save(objFlight));
		
	}
	
	@Override
	public ResponseEntity<Map<String, Boolean>> deleteById(String id) {
		Flight objFlight = fRepository.findById(id).orElseThrow(
						
				()-> new ResourceNotFoundException("Flight not exit with Id: "+ id)
				);
		
		fRepository.delete(objFlight);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted: ", Boolean.TRUE);
		return ResponseEntity.ok(response);
		}


}
