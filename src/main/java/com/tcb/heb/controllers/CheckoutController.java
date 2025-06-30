package com.tcb.heb.controllers;

import com.tcb.heb.dto.CheckoutRequest;
import com.tcb.heb.dto.UpdateCartItemRequest;
import com.tcb.heb.repositories.CartRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckoutController {


    private CartRepository cartRepository;

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(
        @Valid @RequestBody CheckoutRequest request
    ) {
        // Check if cart exists
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);
        if (cart == null) {
            System.out.println("cart is null");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Checkout successful");
    }


}
