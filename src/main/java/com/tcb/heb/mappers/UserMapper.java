package com.tcb.heb.mappers;

import com.tcb.heb.dto.CreateUserRequest;
import com.tcb.heb.dto.UpdateUserRequest;
import com.tcb.heb.dto.UserDto;
import com.tcb.heb.dto.UserLoginRequest;
import com.tcb.heb.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // during compile time, MapStruct will implement this interface for us
    // You can check this in the target folder, under generated sources
    UserDto toDto(User user);
    User toEntity(CreateUserRequest request);
    User toEntity(UserLoginRequest request);

    // This is what manually setting is, but we are using MapStruct mapper instead
    // user.setName(request.getName());
    // user.setEmail(request.getEmail());
    // Must include mappingtarget to prevent compile error
    void updateUser(UpdateUserRequest request, @MappingTarget User user);
}
