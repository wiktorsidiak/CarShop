package com.sidiak.CarShop.repository;

import java.math.BigDecimal;

import com.sidiak.CarShop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Car.class, idClass = String.class)
public interface CarRepo extends JpaRepository<Car, Long> {

    Car save(Car car);

    Car findByMark(String mark);

    Car findByModel(String model);

    Car findByPrice(BigDecimal price);

    Car findByFuel(String fuel);

    Car findByMileage(Integer mileage);

    Car findByYear(Integer year);

    void delete(Long id);
}
