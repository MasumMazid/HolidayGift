package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import models.Customer;
import models.Purchase;
import repository.CustomerRepository;
import services.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidaySpringBootTestApplication {
	
@Autowired
private CustomerService service;

@MockBean
private CustomerRepository Cusrepo;


@Test
public void AddCustomerTest() {
	when(Cusrepo.findAll()).thenReturn((List<Customer>) Stream
			.of(new Customer(44l,"Test User","Test password","Test@gmail.com","User")).collect(Collectors.toList()));
assertEquals(1,((List<Customer>) service.addCustomer(null)).size());
				
}

@Test
public void CheckCustomerLogin() {
	Customer TestCustomer= new Customer(2L,"TestUser","TestPassword","Test@gmail.com","Actve");
	service.addCustomer(TestCustomer);
	assertEquals(2L,service.loginCustom(TestCustomer).getId());
	
}









}
