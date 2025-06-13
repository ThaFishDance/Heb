package com.tcb.heb.controllers;

import com.tcb.heb.dto.AddItemToCartRequest;
import com.tcb.heb.dto.CartDto;
import com.tcb.heb.dto.CartItemDto;
import com.tcb.heb.exceptions.CartNotFoundException;
import com.tcb.heb.exceptions.ProductNotFoundException;
import com.tcb.heb.mappers.CartMapper;
import com.tcb.heb.repositories.CartRepository;
import com.tcb.heb.services.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
@Tag(name="carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(UriComponentsBuilder uriBuilder) {

        CartDto cartDto = cartService.createCart();
        // Generate uri
        var uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId());

        return ResponseEntity.created(uri.toUri()).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addItem(
        @PathVariable UUID cartId,
        @Valid @RequestBody AddItemToCartRequest request
    ) {

        CartItemDto cartItemDto = cartService.addItem(cartId, request.getProductId());
        // return 201
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable UUID cartId) {
        // Check if cart exists
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cartMapper.toDto(cart));
    }

    @PutMapping("/carts/{cartId}/items/{productId}")
    public ResponseEntity<CartDto> updateCart(
        @PathVariable  UUID cartId,
        @PathVariable Long productId

    ){
        System.out.println("Updating cart");
        return null;
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCartNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            Map.of("error", "Cart not found")
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            Map.of("error", "Product not found in cart")
        );
    }
}
