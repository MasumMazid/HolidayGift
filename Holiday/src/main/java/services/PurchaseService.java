package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import models.Customer;
import models.Purchase;
import repository.PurchaseRepository;

public class PurchaseService {
	
	PurchaseRepository PurchaseRepo;
	
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		PurchaseRepo.save(purchase);
		return purchase;
	}
	public List<Object> getAllPurchasebyCustomer(Customer customer){
		List<Object> PurchasesByID = new ArrayList<>();
		long id=customer.getId();
		PurchasesByID.add(PurchaseRepo.findById(id));
		return PurchasesByID;
		
	}
	public String deletePurchase(Purchase purchase){
		PurchaseRepo.delete(purchase);
	return "Your Purchase of id"+ purchase.getPurchase_id()+" has been deleted.";
		
		
	}
	
	
	
}
	
	
	
	


	
		


	
