package org.example.flightticketapp.booking.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.flightticketapp.flight.model.Flight;
import org.example.flightticketapp.payment.model.Payment;
import org.example.flightticketapp.seat.model.Seat;
import org.example.flightticketapp.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @OneToOne
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "myUser_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;
}
