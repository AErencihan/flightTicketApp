package org.example.flightticketapp.ticket.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.flightticketapp.flight.model.Flight;
import org.example.flightticketapp.seat.model.Seat;
import org.example.flightticketapp.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime purchaseDate;

    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

}
