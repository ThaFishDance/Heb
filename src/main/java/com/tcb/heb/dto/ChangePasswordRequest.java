package com.tcb.heb.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @NotNull(message = "Must provide old password")
    private String oldPassword;
    @NotNull(message = "Must provide new password")
    private String newPassword;
}
