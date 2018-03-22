package com.WebServices.PostService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.WebServices.PostService.Exception404;
import com.WebServices.PostService.models.User;
import com.WebServices.PostService.repositories.UserRepository;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new Exception404("(GET) api/users/id", userId));
    }
    
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user, HttpServletResponse response) {
        response.addHeader("Location", "api/users");
        response.setStatus(201);
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User newUser) {

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception404("(PUT) api/users", userId));

        user.setEmail(newUser.getEmail());
        user.setUsername(newUser.getUsername());

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception404("(DELETE) api/users/id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
