package com.tcb.heb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class UserDto {
    @JsonProperty("user_id")
    public Long id;
    public String name;
    public String email;
}
