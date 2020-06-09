package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.Car;
import com.sidiak.CarShop.model.CarCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepo extends JpaRepository<Car, String> {
    CarCategoryModel findByCategory(final String category);
}
