package com.cognixia.jump.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.cognixia.jump.model.Purchase;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repo.PurchaseRepository;

@Service
public class PurchaseService {
	@Autowired
	PurchaseRepository PurchaseRepo;
	
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		PurchaseRepo.save(purchase);
		return purchase;
	}
//	public List<Object> getAllPurchasebyCustomer(Customer customer){
//		List<Object> PurchasesByID = new ArrayList<>();
//		long id=customer.getId();
//		PurchasesByID.add(PurchaseRepo.findById(id));
//		return PurchasesByID;
//		
//	}
	
	public List<Object> getAllPurchasebyCustomer(User user){
		List<Object> PurchasesByID = new ArrayList<>();
		long id=user.getId();
		PurchasesByID.add(PurchaseRepo.findById(id));
		return PurchasesByID;
		
	}
	
	
	
	public String deletePurchase(Purchase purchase, long user){
		
			if(purchase.getUser_id()==user) {	
				PurchaseRepo.delete(purchase);
				String s = String.valueOf(purchase.getPurchase_id());
				return s;
			}else {
				return "No such order";
			}
		}

	
	
	
	
}
	
	
	
	


	
		


	
