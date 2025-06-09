package com.tcb.heb.controllers;

import com.tcb.heb.entities.User;
import com.tcb.heb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor // Lombok for userRepository
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll(); // returns an iterable not a list
    }
}
