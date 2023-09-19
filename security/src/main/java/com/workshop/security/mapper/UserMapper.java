package com.workshop.security.mapper;

import com.workshop.security.dtos.UserDto;
import com.workshop.security.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToUser(UserDto userDto);
    UserDto userToDto(User user);
}
