package com.tcb.heb.mappers;

import com.tcb.heb.dto.RegisterUserRequest;
import com.tcb.heb.dto.UpdateUserRequest;
import com.tcb.heb.dto.UserDto;
import com.tcb.heb.dto.LoginRequest;
import com.tcb.heb.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}