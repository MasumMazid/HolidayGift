package com.cognixia.jump.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@DeleteMapping("/purchaseList/{user_id}/{purchase_id}")
    public String  deletePurchase(@PathVariable int user_id,@PathVariable int purchase_id) {
		
		return purchaseService.deletePurchase(user_id, purchase_id);
    	
    }	
	
	@PostMapping("/{user_id}/add")
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		return purchaseService.addPurchase(purchase);
	}
	
	/*@DeleteMapping("/delete/{purchase_id}/{user_id}")
	public String removeGift(@RequestBody Purchase purchase, @RequestBody long user_id) {
		return purchaseService.deletePurchase(purchase, user_id);
	}*/
	
	@GetMapping("/purchaseList/{user_id}")
	public List<Purchase> getAllPurchasebyCustomer(@PathVariable int user_id){
	
		return purchaseService.getAllPurchaseByCustomer(user_id);
	}
	
	

	
}