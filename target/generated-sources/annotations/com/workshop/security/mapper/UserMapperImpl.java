package com.workshop.security.mapper;

import com.workshop.security.dtos.UserDto;
import com.workshop.security.models.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-20T12:06:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User dtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( userDto.getFirstName() );
        user.lastName( userDto.getLastName() );
        user.email( userDto.getEmail() );
        user.password( userDto.getPassword() );
        user.role( userDto.getRole() );

        return user.build();
    }

    @Override
    public UserDto userToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.email( user.getEmail() );
        userDto.password( user.getPassword() );
        userDto.role( user.getRole() );

        return userDto.build();
    }
}
