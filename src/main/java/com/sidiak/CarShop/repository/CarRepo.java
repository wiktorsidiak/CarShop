package com.sidiak.CarShop.repository;

import java.util.List;

import com.sidiak.CarShop.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Car.class, idClass = String.class)
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAll();

    Car save(Car car);

    Car findByMark(Car mark);

    Car findByModel(Car model);

    Car findByPrice(Car price);

    Car findByFuel(Car fuel);

    Car findByMileage(Car mileage);

    Car findByYear(Car year);

    void delete(Car carId);
}
