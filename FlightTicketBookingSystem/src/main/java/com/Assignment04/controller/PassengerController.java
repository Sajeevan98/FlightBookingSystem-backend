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

import com.Assignment04.model.Passenger;
import com.Assignment04.service.PassengerService;

@RestController
@RequestMapping("/")
public class PassengerController {

	@Autowired
	private PassengerService pService;
	
	// get All Passenger
	@GetMapping("/passenger/all")
	public List<Passenger> getAll(){
		
		return pService.getAllPassenger();
	}
	
	//add Passenger
	@PostMapping("/passenger/add")
	public String add(@RequestBody Passenger pModel) {
		
		pService.addPassenger(pModel);
		return "Passenger Successfully added!";
	}
	
	// update passenger
	@PutMapping("/passenger/update:{id}")
	public Optional<Passenger> update(@PathVariable("id") long id, @RequestBody Passenger pModel){
		
		return pService.updatePassenger(id, pModel);
	}
	
	@DeleteMapping("/passenger/delete:{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable("id") long id){
		
		return pService.deletePassenger(id);
	}
}
