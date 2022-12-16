package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.User;
import com.cognixia.jump.service.UserService;

// @CrossOrigin(origins = "http://54.157.103.186:8080")
// @CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService repo;

	@Autowired
	PasswordEncoder encoder;

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return repo.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) throws ResourceNotFoundException {

		Optional<User> found = repo.findById(id);

		// best practices: use exception handled here
		if (found.isEmpty()) {
			return ResponseEntity.status(404).body("User with id = " + id + "not found");
		}
		return ResponseEntity.status(202).body(found.get());

	}

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		// make sure id is autoincremented
		user.setId(null);
		// before user gets saved to db, password should be encoded
		user.setPassword(encoder.encode(user.getPassword()));

		// after encoded save the user
		User created = repo.saveUser(user);

		return ResponseEntity.status(201).body(created);
	}

	@GetMapping("/finduser/username")
	public ResponseEntity<?> getUserByName(@RequestParam String username) {
		Optional<User> user = repo.findByUserName(username);
		if (user.isEmpty()) {
			return ResponseEntity.status(404).body("Username: " + username + " Not found");
		}
		return ResponseEntity.status(202).body(user);
	}

	// @DeleteMapping("/userDelete/username")
	// public ResponseEntity<?> deleteUser(@RequestParam String username){
	// 	Optional<User> user = repo.findByUserName(username);

	// 	if(user.isEmpty()){
	// 		return ResponseEntity.status(404).body("Username: " + username + " Not found");
	// 	}
	// 	repo.delete(username);
	// 	return ResponseEntity.status(202).body("Username: " + username + " successfull deleted");

	// }

}
