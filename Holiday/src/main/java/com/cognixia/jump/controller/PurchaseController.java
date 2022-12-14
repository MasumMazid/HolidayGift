package com.cognixia.jump.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Purchase;
import com.cognixia.jump.model.User;
import com.cognixia.jump.service.PurchaseService;



@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
		
	
	@PostMapping("/add")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		return purchaseService.addPurchase(purchase);
	
	}
	
	@DeleteMapping
	public long removeGift(@RequestBody Purchase purchase) {
		return purchaseService.deletePurchase(purchase);
	}
	
	@GetMapping("/purchaseid/{username}")
	public List<Object> getAllPurchasebyCustomer(@PathVariable User user) {
		return purchaseService.getAllPurchasebyCustomer(user);
		
	}



	
}