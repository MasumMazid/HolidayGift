package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    // @Autowired
    // UserDetailsService userdetailsService;

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public Optional<User> findById(int id){
        return repo.findById(id);
    }

    public User saveUser(User user){
        return repo.save(user);
    }

    public Optional<User> findByUserName(String username){
        return repo.findbyUsername(username);
    }

}
