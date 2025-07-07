package org.example.flightticketapp.seat.repository;

import org.example.flightticketapp.seat.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
