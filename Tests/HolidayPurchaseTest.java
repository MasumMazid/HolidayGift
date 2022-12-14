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
import repository.PurchaseRepository;
import services.CustomerService;
import services.PurchaseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidayPurchaseTest {
	@Autowired
	private PurchaseRepository repo;

	
	@MockBean
	private PurchaseService service;
	
	@Test
	public void AddPurchaseTest() {
	Purchase TestPurchase= new Purchase(2L,2,2,2);
	Long check= 2l;
	service.addPurchase(TestPurchase);
	assertEquals(check,service.deletePurchase(TestPurchase));
}
}





