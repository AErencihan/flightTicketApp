package org.example.flightticketapp.ticket.repository;

import org.example.flightticketapp.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
