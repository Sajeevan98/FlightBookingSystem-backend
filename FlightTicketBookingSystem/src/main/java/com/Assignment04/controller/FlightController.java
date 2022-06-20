package com.Assignment04.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Assignment04.model.Flight;
import com.Assignment04.model.Ticket;
import com.Assignment04.service.FlightService;

@RestController
@RequestMapping("/")
public class FlightController {

	@Autowired
	private FlightService fService;
	
	//----get all Flight details----
	@GetMapping("/flight/all")
	public List<Flight> getAllFlight(){
		
		return fService.getAll();
	}
	
	//----get flight-details by flight-Id---- 
	@GetMapping("/flight/id:{id}")
	public Optional<Flight> findFlightById(@PathVariable("id") String id){
		
		return fService.getById(id);
	}
	
	//----add flight details----
	@PostMapping("/flight/add")
	public String addFlightDetails(@RequestBody Flight fModel){
		
		fService.addFlight(fModel);
		return "Flight Details Successfully Added!";
	}
	
	
	//----update Flight details----
	@PutMapping("/flight/update:{id}")
	public Optional<Flight> updateFlightDetails(@PathVariable("id") String id ,@RequestBody Flight fModel){
		
		return fService.updateFlight(id, fModel);
	}
	
	//----delete Flight details----
	@DeleteMapping("/flight/delete:{id}")
	public ResponseEntity <Map<String, Boolean>> deleteFlight(@PathVariable String id){
			
			return fService.deleteById(id);
	}
	
		
	//----get reserved-tickets-details by flight-Id---- (using foreign-key)
	@GetMapping("/flight:{id}/reserved-tickets")
	public List<Ticket> findTicketByFlight(@PathVariable("id") String id){
		
		return fService.getTicketByFlight(id);
	}
		
	
}
