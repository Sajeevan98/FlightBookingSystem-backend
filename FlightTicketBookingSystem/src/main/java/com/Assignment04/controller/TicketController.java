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

import com.Assignment04.model.Ticket;
import com.Assignment04.service.TicketService;

@RestController
@RequestMapping("/")
public class TicketController {

	@Autowired
	private TicketService tService;
	
	//----get all ticket details----
	@GetMapping("/ticket/all")
	public List<Ticket> findAllTicket(){
		
		return tService.getAll();		
	}
	
	//----get ticket-details by ticket-Id----
	@GetMapping("/ticket/id:{id}")
	public Optional<Ticket> findTicketById(@PathVariable("id") long id){
		
		return tService.getById(id);
	}
	
	//----add Ticket details----
	@PostMapping("/ticket/add")
	public String addTicketDetails(@RequestBody Ticket tModel){
		
		tService.addTicket(tModel);
		return "Ticket Added Successfully!";
	}
	
	//----update Ticket details----
	@PutMapping("/ticket/update:{id}")
	public Optional<Ticket> updateTicketDetails(@PathVariable("id") long id ,@RequestBody Ticket tModel){
		
		return tService.updateTicket(id, tModel);
	}
	
	//----delete Ticket details----
	@DeleteMapping("/ticket/delete:{id}")
	public ResponseEntity <Map<String, Boolean>> deleteTicket(@PathVariable long id){
			
			return tService.deleteById( id);
	}
}
