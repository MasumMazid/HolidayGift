package com.cognixia.jump.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
	@Query("SELECT a FROM Purchase a")
	 public List<Purchase> getAllPurchases();
}
