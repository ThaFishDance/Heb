package com.tcb.heb.mappers;

import com.tcb.heb.dto.RegisterUserRequest;
import com.tcb.heb.dto.UserDto;
import com.tcb.heb.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // during compile time, MapStruct will implement this interface for us
    // You can check this in the target folder, under generated sources
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
}
