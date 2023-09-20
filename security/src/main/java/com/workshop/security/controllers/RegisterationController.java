package com.workshop.security.controllers;

import com.workshop.security.dtos.*;
import com.workshop.security.exceptions.UserExistException;
import com.workshop.security.service.RegisterationServiceImpl;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterationController {
    @Autowired
    RegisterationServiceImpl registerationService;

    @PostMapping("/")
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto user) throws UserExistException {

        System.out.println(user.getEmail());
        UserDto userDto1 = this.registerationService.addUser(user);

        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        List<UserDto> userDtoList = this.registerationService.getUsers();

        return ResponseEntity.ok(userDtoList);
    }
}