package com.tcb.heb.controllers;

import com.tcb.heb.dto.AddItemToCartRequest;
import com.tcb.heb.dto.CartDto;
import com.tcb.heb.dto.CartItemDto;
import com.tcb.heb.entities.Cart;
import com.tcb.heb.entities.CartItem;
import com.tcb.heb.mappers.CartMapper;
import com.tcb.heb.repositories.CartRepository;
import com.tcb.heb.repositories.ProductRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
        UriComponentsBuilder uriBuilder
    ) {
        var cart = new Cart();
        cartRepository.save(cart);
        var cartDto = cartMapper.toDto(cart);
        var uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId());

        return ResponseEntity.created(uri.toUri()).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addItem(
        @PathVariable UUID cartId,
        @Valid @RequestBody AddItemToCartRequest request
    ) {
        System.out.println(request);
        // Check if cart exists
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        // check if item exists in products table
        var product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        // Check to see if product exists in cart
        var cartItem = cart.getItems().stream()
            .filter(item -> item.getProduct().getId().equals(product.getId()))
            .findFirst()
            .orElse(null);

        if (cartItem != null) {
            // since we dont want duplicates we just increase
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            // Create new cart item
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            // set cart
            cartItem.setCart(cart);
            // add item to the cart
            cart.getItems().add(cartItem);
        }

        // save
        cartRepository.save(cart);

        // mapping
        CartItemDto cartItemDto = cartMapper.toDto(cartItem);

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
}
