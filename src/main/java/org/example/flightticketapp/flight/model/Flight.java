package org.example.flightticketapp.flight.model;


import jakarta.persistence.*;
import lombok.Data;
import org.example.flightticketapp.booking.model.Booking;
import org.example.flightticketapp.seat.model.Seat;
import org.example.flightticketapp.ticket.model.Ticket;

import java.util.List;

@Entity(name = "flights")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightCode;

    private String origin;

    private String destination;

    private String departureTime;

    private String arrivalTime;

    private String aircraftType;

    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @OneToMany(mappedBy = "flight")
    private List<Seat> seats;

    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;
}
