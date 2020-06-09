package com.sidiak.CarShop.repository;

import com.sidiak.CarShop.model.Car;
import com.sidiak.CarShop.model.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepo extends JpaRepository<CarCategory, String> {
    CarCategory findByCategory(Car category);

}
