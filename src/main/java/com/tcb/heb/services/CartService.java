package com.tcb.heb.services;

import com.tcb.heb.dto.CartDto;
import com.tcb.heb.dto.CartItemDto;
import com.tcb.heb.entities.Cart;
import com.tcb.heb.entities.CartItem;
import com.tcb.heb.exceptions.CartNotFoundException;
import com.tcb.heb.exceptions.ProductNotFoundException;
import com.tcb.heb.mappers.CartMapper;
import com.tcb.heb.repositories.CartRepository;
import com.tcb.heb.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;
    private CartMapper cartMapper;
    private ProductRepository productRepository;

    public CartDto createCart(){
        Cart cart = new Cart();
        cartRepository.save(cart);
        return cartMapper.toDto(cart);
    }

    public CartItemDto addItem(UUID cartId, Long productId) {
        // Check if cart exists
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        // check if item exists in products table
        var product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException();
        }

        // Check to see if product exists in cart
        CartItem cartItem = cart.getItems().stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst()
            .orElse(null);

        if (cartItem != null) {
            // since we don't want duplicates we just increase
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

        // mapping for CartItemDto
        return cartMapper.toDto(cartItem);
    }
}
