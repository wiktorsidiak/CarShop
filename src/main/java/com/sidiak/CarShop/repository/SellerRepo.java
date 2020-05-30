package com.sidiak.CarShop.repository;

import java.util.UUID;

import com.sidiak.CarShop.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, UUID> {
    Seller save();

    Seller update();

    Seller delete();
}
