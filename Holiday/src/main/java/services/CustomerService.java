package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Customer;
import repository.CustomerRepository;
import services.CustomerService;

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
	

