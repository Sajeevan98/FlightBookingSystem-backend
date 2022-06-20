package com.Assignment04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Assignment04.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
