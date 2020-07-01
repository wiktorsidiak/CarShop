package com.sidiak.CarShop.service.Seller;

import com.sidiak.CarShop.model.Seller;
import com.sidiak.CarShop.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerServiсe {

	@Autowired
	private SellerRepo sellerRepo;

	@Override
	public List<Seller> getAll(Seller seller) {
		return sellerRepo.findAll();
	}

}
