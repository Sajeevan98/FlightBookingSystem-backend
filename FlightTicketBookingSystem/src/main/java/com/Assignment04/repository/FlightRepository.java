package com.Assignment04.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Assignment04.model.Flight;
import com.Assignment04.model.Ticket;

public interface FlightRepository extends JpaRepository<Flight, String>{

	@Query(" select tickets from Flight f where f.id=?1 ")
	List<Ticket> getTicketByFlightId(String id);

}
