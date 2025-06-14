package com.tcb.heb.controllers;

import com.tcb.heb.dto.UserLoginRequest;
import com.tcb.heb.entities.User;
import com.tcb.heb.mappers.UserMapper;
import com.tcb.heb.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "auth")
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(
        @Valid @RequestBody UserLoginRequest userLoginRequest
    ) {

        // Check for email in DB
        User user = userRepository.findUserByEmail(userLoginRequest.getEmail());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "User not found")
            );
        }

        // Check if passwords match
        var reqPassword = passwordEncoder.encode(userLoginRequest.getPassword());

        System.out.println(reqPassword);
        System.out.println(user.getPassword());

        if (!reqPassword.equals(user.getPassword())) {
            System.out.println("Password does not match");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("error", "Password does not match")
            );
        }

        // Return Success
        return ResponseEntity.ok().build();
    }

}
