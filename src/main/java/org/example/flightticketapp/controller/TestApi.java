package org.example.flightticketapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {


    @GetMapping("/api")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test API is working!");
    }

}
