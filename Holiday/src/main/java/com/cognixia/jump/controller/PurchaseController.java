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
	
		
	
	@PostMapping("/{user_id}/add")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		return purchaseService.addPurchase(purchase);
	}
	
	@DeleteMapping("/delete/{purchase_id}/{user_id}")
	public String removeGift(@RequestBody Purchase purchase, @RequestBody long user_id) {
		return purchaseService.deletePurchase(purchase, user_id);
	}
	
	@GetMapping("/purchaseList/{user_id}")
	public List<Object> getAllPurchasebyCustomer(@PathVariable User user) {
		return purchaseService.getAllPurchasebyCustomer(user);
	}



	
}