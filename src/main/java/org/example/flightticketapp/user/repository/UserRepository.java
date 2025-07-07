package org.example.flightticketapp.user.repository;

import org.example.flightticketapp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
