package com.sidiak.CarShop.repository;

import java.util.List;

import com.sidiak.CarShop.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {

    List<Seller> findAll(Long id);

    Seller findByFirstName(String firstName);
}
