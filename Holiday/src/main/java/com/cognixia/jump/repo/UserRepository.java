package com.cognixia.jump.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // - Custom query for finding a user by its username
    // - will be used when username + password through the API request
    // We'll need a way to look up the user
    // - Optional is returned b/c there's a chance the username doesn't exist in our
    // user table
    public Optional<User> findByUsername(String username);
}
