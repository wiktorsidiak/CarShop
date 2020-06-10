package com.sidiak.CarShop.service;

import java.util.List;

import com.sidiak.CarShop.model.Seller;

public interface SellerServiсe {
    List<Seller> getAll(Seller seller);

    Seller findByFirstName(String firstName);


}
