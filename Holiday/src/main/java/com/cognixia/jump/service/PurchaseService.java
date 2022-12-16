package com.cognixia.jump.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.cognixia.jump.model.Purchase;
import com.cognixia.jump.repo.PurchaseRepository;


// Service for MySQL database, pr and Purchases  
@Service
public class PurchaseService {
	@Autowired
	PurchaseRepository PurchaseRepo;
	
	public Purchase addPurchase(@RequestBody Purchase purchase) {
		PurchaseRepo.save(purchase);
		return purchase;
	}

	
	public List<Purchase> getAllPurchaseByCustomer(int UserId){
		
		
		List<Purchase> Purchases= PurchaseRepo.getAllPurchases();
		List<Purchase> PurchasesByID = new ArrayList<Purchase>();
		for (Purchase p: Purchases) {
			if(p.getUser_id()==UserId) {
				PurchasesByID.add(p);
			}
		}
		return PurchasesByID;
	}
	
	public String deletePurchase(int UserID,int PurchaseID ){
		List<Purchase> Purchases= PurchaseRepo.getAllPurchases();
		for (Purchase p: Purchases) {
			if(p.getPurchase_id()==PurchaseID && p.getUser_id()==UserID) {
				PurchaseRepo.delete(p);
				return "Your purchase has been deleted";
			}
		}
		
	
		return "Purchase not found";
			
		}
	
}
	
	
	
	


	
		


	
