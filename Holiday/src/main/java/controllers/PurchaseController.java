package controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Customer;
import models.Purchase;
import services.PurchaseService;



@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
@Autowired
PurchaseService purchaseService;

	

@PostMapping	
public Purchase addPurchase(@RequestBody Purchase purchase) {
	return purchaseService.addPurchase(purchase);

}

@DeleteMapping
public String removeGift(@RequestBody Purchase purchase) {
	return purchaseService.deletePurchase(purchase);
}

@GetMapping("/purchaseid/{id}")
public List<Object> getAllPurchasebyCustomer(@PathVariable Customer customer) {
	return purchaseService.getAllPurchasebyCustomer(customer);
	
}



	
}