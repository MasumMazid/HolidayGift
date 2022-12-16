package com.cognixia.jump.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Helloworld {
@GetMapping("/helloworld")
public String getMessage() {
	return "Hello World";
}
	
	
	
	
}
