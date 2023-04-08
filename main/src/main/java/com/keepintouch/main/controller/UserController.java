package com.keepintouch.main.controller;

import com.keepintouch.main.model.dto.UserDto;
import com.keepintouch.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/1.0/users")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok("User created.");
    }
}
