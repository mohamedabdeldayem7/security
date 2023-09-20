package com.workshop.security.service;

import com.workshop.security.dtos.UserDto;
import com.workshop.security.exceptions.UserExistException;
import com.workshop.security.mapper.UserMapper;
import com.workshop.security.models.constants.Role;
import com.workshop.security.models.entities.User;
import com.workshop.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisterationServiceImpl {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserDto addUser(UserDto userDto) throws UserExistException {

        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new UserExistException("email: " + userDto.getEmail() + "is already exist !");
        }

        userDto.setRole(Role.ROLE_USER);
        User user = userMapper.dtoToUser(userDto);
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));

        User userDetails = userRepository.save(user);

        return userMapper.userToDto(userDetails);
    }

    public List<UserDto> getUsers(){
        List<User> users = this.userRepository.findAll();

        return users.stream().map(user -> this.userMapper.userToDto(user))
                .collect(Collectors.toList());
    }
}
