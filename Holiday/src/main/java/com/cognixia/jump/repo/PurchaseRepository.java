package com.cognixia.jump.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Purchase;
import com.cognixia.jump.model.User;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    // public List<Purchase> findByUserId(@Param("user_id") Integer userid);

}
