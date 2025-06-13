package com.tcb.heb.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateCartItemRequest {
    @NotNull(message = "Quantity must provided")
    @Min(value = 1)
    @Max(value = 100)
    private Integer quantity;
}
