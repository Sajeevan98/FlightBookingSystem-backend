package com.Assignment04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Assignment04.exception.ResourceNotFoundException;
import com.Assignment04.model.Ticket;
import com.Assignment04.repository.TicketRepository;

@Service
public class TicketServiceImp implements TicketService{

	@Autowired
	private TicketRepository tRepositoty;
	
	@Override
	public List<Ticket> getAll() {
		
		return tRepositoty.findAll();
	}

	@Override
	public Optional<Ticket> getById(long id) {
		
		Ticket objTicket = tRepositoty.findById(id).orElseThrow(
				
				()-> new ResourceNotFoundException("Ticket not exit with Id: "+ id)
				);
		return Optional.ofNullable(objTicket);
		
	}

	@Override
	public Ticket addTicket(Ticket tModel) {
		
		return tRepositoty.save(tModel);
	}

	@Override
	public Optional<Ticket> updateTicket(long id, Ticket tModel) {
		Ticket objTicket = tRepositoty.findById(id).orElseThrow(
				
				()-> new ResourceNotFoundException("Ticket not exit with Id: "+ id)
				);
		objTicket.setPrice(tModel.getPrice());
		objTicket.setSeatNo(tModel.getSeatNo());
		
		return Optional.ofNullable(tRepositoty.save(objTicket));
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteById(long id) {
		Ticket objTicket = tRepositoty.findById(id).orElseThrow(
						
				()-> new ResourceNotFoundException("Ticket not exit with Id: "+ id)
				);
		
		tRepositoty.delete(objTicket);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted: ", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
}
