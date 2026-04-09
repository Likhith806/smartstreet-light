package com.smartlight.controller;

import com.smartlight.entity.User;
import com.smartlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    // Register API
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // Login API
    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
}