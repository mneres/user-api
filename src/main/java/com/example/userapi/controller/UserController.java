package com.example.userapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userapi.model.User;
import com.example.userapi.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        List<User> response = this.userService.findAll();
        return new ResponseEntity<List<User>>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = this.userService.save(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(String id) {
        Optional<User> user = this.userService.findById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (!user.isPresent()) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<User>(user.get(), httpStatus);
    }
}
