package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.Car.Car;
import com.sidiak.CarShop.model.Car.CarCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepo extends JpaRepository<Car, String> {
	CarCategoryModel findByCategory(final String category);
}
