package com.tcb.heb.dto;

import com.tcb.heb.entities.Product;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CartDto {
    private UUID id;
    private List<Product> items;
    private double totalPrice;
}
