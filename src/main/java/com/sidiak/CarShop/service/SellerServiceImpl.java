package com.sidiak.CarShop.service;

import java.util.List;

import com.sidiak.CarShop.model.Seller;
import com.sidiak.CarShop.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerServiсe {

    @Autowired
    private SellerRepo sellerRepo;

    @Override
    public List<Seller> getAll(Seller seller) {
    return sellerRepo.findAll();
    }

    @Override
    public Seller findByFirstName(String firstName) {
        return sellerRepo.findByFirstName(firstName);
    }
}
