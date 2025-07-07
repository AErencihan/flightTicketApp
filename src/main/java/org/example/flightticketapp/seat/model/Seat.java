package org.example.flightticketapp.seat.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.flightticketapp.booking.model.Booking;
import org.example.flightticketapp.flight.model.Flight;

import java.util.List;

@Entity(name = "seats")
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatCode;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @OneToMany(mappedBy = "seat")
    private List<Booking> bookings;

}
