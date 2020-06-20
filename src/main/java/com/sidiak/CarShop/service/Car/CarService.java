package com.sidiak.CarShop.service.Car;

import java.util.List;

import com.sidiak.CarShop.model.Car.Car;
import com.sidiak.CarShop.model.Car.CarCategoryModel;


public interface CarService {

    Car save(Car car);

    List<Car> getAll(Car car);

    Car getCarsByMark(Car mark);

    Car getCarsByModel(Car model);

    CarCategoryModel getCarsByCategory(Car category);

    Car getCarsByPrice(Car price);

    Car getCarsByMileage(Car mileage);

    Car getCarsByFuel(Car fuel);

    Car getCarsByYear(Car year);

    void deleteCar(Car carId);
}
