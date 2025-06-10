package com.tcb.heb.controllers;

import com.tcb.heb.dto.RegisterUserRequest;
import com.tcb.heb.dto.UserDto;
import com.tcb.heb.mappers.UserMapper;
import com.tcb.heb.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor // Lombok for userRepository
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriBuilder) {
        var user = userMapper.toEntity(request);
        userRepository.save(user);

        // after save, we include header for single user
        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        // return 201
        return ResponseEntity.created(uri).body(userDto);
    }

}
