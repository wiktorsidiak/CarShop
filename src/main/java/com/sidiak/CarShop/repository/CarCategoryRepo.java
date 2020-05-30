package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCategoryRepo extends JpaRepository<CarCategory, String> {
    CarCategory findByCategoryName(String category);

}
