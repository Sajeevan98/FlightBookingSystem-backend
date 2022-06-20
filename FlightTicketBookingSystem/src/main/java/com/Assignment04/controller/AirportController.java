package com.Assignment04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.Assignment04.exception.ResourceNotFoundException;
import com.Assignment04.model.Airport;
import com.Assignment04.repository.AirportRepository;

@RestController
@RequestMapping("/")
public class AirportController {

	@Autowired
	AirportRepository aRepository;
	
	//Get
	@GetMapping("/airport/all")
	public List<Airport> getAirportDetails() {
		
		return aRepository.findAll();
	}
	
	//Save
	@PostMapping("/airport/add")
	public String addAirportDetails(@RequestBody Airport airModel) {
		
		aRepository.save(airModel);
		return "Data added Successfully!";
	}
	
	//update
	@PutMapping("/airport/update:{id}")
    public ResponseEntity<Airport> updateAirportDetails(@PathVariable("id") long id, @RequestBody Airport airModel){
		Airport objAirport = aRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Product not exit with Id: "+ id)
        );
		objAirport.setName(airModel.getName());
		objAirport.setCountry(airModel.getCountry());
		objAirport.setState(airModel.getState());
       

		Airport updateAirportt = aRepository.save(objAirport);
        return ResponseEntity.ok(updateAirportt);
    }
	
	//delete
	@DeleteMapping("/airport/delete:{id}")
	public ResponseEntity <Map<String, Boolean>> deleteAirportDetails(@PathVariable long id){
		
		aRepository.deleteById(id);
        Map<String,Boolean> status = new HashMap<>();
        status.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(status);
	}
}
