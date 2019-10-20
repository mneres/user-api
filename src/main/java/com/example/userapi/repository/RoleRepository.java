package com.example.userapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userapi.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    public Role findByRole(String role);
}
