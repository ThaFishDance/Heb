package com.tcb.heb.controllers;

import com.tcb.heb.dto.ChangePasswordRequest;
import com.tcb.heb.dto.CreateUserRequest;
import com.tcb.heb.dto.UpdateUserRequest;
import com.tcb.heb.dto.UserDto;
import com.tcb.heb.entities.Role;
import com.tcb.heb.mappers.UserMapper;
import com.tcb.heb.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor // Lombok for userRepository
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toDto) // since map is expected a lambda
            .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
        @Valid @RequestBody CreateUserRequest request,
        UriComponentsBuilder uriBuilder) {
        // Turn req into ent
        var user = userMapper.toEntity(request);
        // Hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Set Role
        user.setRole(Role.USER);
        // Save user to db
        userRepository.save(user);

        // after save, we include header for single user
        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        // return 201
        return ResponseEntity.created(uri).body(userDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
        @PathVariable(name = "id") Long id,
        @RequestBody UpdateUserRequest request
    ) {
        // check to see if user exists
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        userMapper.updateUser(request, user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> changePassword(
        @PathVariable Long id,
        @RequestBody ChangePasswordRequest request) {

        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        if (!user.getPassword().equals(request.getOldPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();

    }

}
