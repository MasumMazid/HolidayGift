package com.cognixia.jump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repo.CustomerRepository;
import com.cognixia.jump.service.CustomerService;

@Service
public class CustomerService {
	
CustomerRepository repo;
	
	
	

	public Customer addCustomer(Customer customer) {
		repo.save(customer);
		return customer;
		
	}
	public Customer loginCustom(Customer customer) {
		if(repo.findById(customer.getId())!=null) {
			return customer;
		}else {
			return null;
			}
		}
	
	}
	

