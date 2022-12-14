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





@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
@Autowired
PurchaseController purchaseController;

	

@PostMapping	
public PurchaseController addGift(@RequestBody PurchaseController purchaseController) {
	return purchaseController;
}

@DeleteMapping
public PurchaseController removeGift(@RequestBody PurchaseController purchaseController) {
	return purchaseController;
}

@GetMapping("/id/{id}")
public PurchaseController getAllPurchases(@PathVariable long id) {
	
	return purchaseController.getAllPurchases(id);
}



	
}