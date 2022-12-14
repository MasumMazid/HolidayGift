package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repo.CustomerRepository;
import com.cognixia.jump.service.CustomerService;
import com.cognixia.jump.service.GiftService;

@RestController
@RequestMapping("/login")
public class CustomerController {
	@Autowired
	CustomerService service;
	
	
	@PostMapping("/newAccount")	
	public Customer  NewCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	
	}

	@GetMapping("/id/{id}")
	public  Customer login(@PathVariable Customer customer){
		return service.loginCustom(customer);
		
	}
	@GetMapping("/test")
	public String test() {
		return "Its working";
	}
	
}