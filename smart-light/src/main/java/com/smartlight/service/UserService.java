package com.smartlight.service;

import com.smartlight.entity.User;
import com.smartlight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Register user
    public User register(User user) {
        return repo.save(user);
    }

    // Login validation
    public boolean login(String username, String password) {
        User user = repo.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}