package com.cognixia.jump.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
@GetMapping("/helloworld")
public String getMessage() {
	return "Hello World";
}
	
	
	
	
}