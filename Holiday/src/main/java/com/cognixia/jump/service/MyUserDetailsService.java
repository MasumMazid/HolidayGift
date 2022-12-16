package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repo.UserRepository;

// Service class that manages/helps in locating users so they can
// be authenticated and provide spring security with their info
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository repo;

    // Any time spring security needs to check for a user, they will call
    // the loadByUsername() method from this service class
    // Spring security will pass in the username it knows and get back a UserDetails
    // object that contains all the info they are going to need to make sure
    // security
    // is checked properly
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userFound = repo.findByUsername(username);

        // if we can't find the user in our table, that means they don't exist
        if (userFound.isEmpty()) {
            //return ResponseEntity.status(404).body("User not found");
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(userFound.get());
    }

}
