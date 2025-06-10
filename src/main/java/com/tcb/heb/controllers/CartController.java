package com.tcb.heb.controllers;

import com.tcb.heb.entities.Cart;
import com.tcb.heb.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;


    @PostMapping
    public ResponseEntity<Void> createCart() {
        cartRepository.save(new Cart());

        return null;
    }
}
