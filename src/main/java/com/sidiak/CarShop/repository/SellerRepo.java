package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {

	List<Seller> findAll();

	Seller findByFirstName(String firstName);
}
