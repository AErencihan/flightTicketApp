package org.example.flightticketapp.payment.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.flightticketapp.booking.model.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumberMasked;

    private String paymentMethod;

    private BigDecimal amount;

    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
}
