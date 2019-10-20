package com.example.userapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userapi.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);
}
