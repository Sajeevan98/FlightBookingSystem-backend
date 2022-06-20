package com.Assignment04.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Assignment04.model.Ticket;

public interface TicketService {

	public List<Ticket> getAll();
	public Optional<Ticket> getById(long id);
	public Ticket addTicket(Ticket tModel);
	public Optional<Ticket> updateTicket(long id, Ticket tModel);
	public ResponseEntity<Map<String, Boolean>> deleteById(long id);

}
