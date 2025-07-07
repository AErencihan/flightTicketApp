package org.example.flightticketapp.user.service;

import org.example.flightticketapp.user.model.User;
import org.example.flightticketapp.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByUserName(String username){
        return userRepository.findUserByName(username)
                .orElseThrow(()-> new RuntimeException("User not found with username: " + username));
    }
}
