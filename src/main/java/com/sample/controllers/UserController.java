package com.sample.controllers;

import com.sample.Service.UserService;
import com.sample.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/")
    public List<UserDto> getAllUsers() {
        System.out.println("Reached!!!! out");
        log.debug("Reached!!!!");
        return userService.getUsers();
    }

    @PostMapping(path = "/")
    public UserDto createUser(@RequestBody UserDto user) {
        System.out.println("User creation");
        return user;
    }
}
