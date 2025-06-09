package com.tcb.heb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    public Long id;
    public String name;
    public String email;
}
