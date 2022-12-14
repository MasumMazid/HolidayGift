package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Purchase;



public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
