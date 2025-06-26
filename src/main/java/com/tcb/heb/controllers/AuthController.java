package com.tcb.heb.controllers;

import com.tcb.heb.dto.JwtResponse;
import com.tcb.heb.dto.UserLoginRequest;
import com.tcb.heb.services.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
        @Valid @RequestBody UserLoginRequest request
    ) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        String token = jwtService.generateToken(request.getEmail());

        // Return Success
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<Void> handleBadCredentialsException(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
