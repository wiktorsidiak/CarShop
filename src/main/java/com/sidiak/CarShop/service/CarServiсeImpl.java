package com.sidiak.CarShop.service;

import java.util.List;

import com.sidiak.CarShop.model.Car;
import com.sidiak.CarShop.model.CarCategory;
import com.sidiak.CarShop.repository.CarCategoryRepo;
import com.sidiak.CarShop.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CarServiсeImpl implements CarService {

    private CarRepo carRepo;
    private CarCategoryRepo carCategoryRepo;
    @Override
    public Car save(Car car) {
        Car newCar = carRepo.save(car);
        return car;
    }

    @Override
    public List<Car> getAll(Car car) {
        return carRepo.findAll();
    }
    @Override
    public Car getCarsByMark(Car mark) {
        return carRepo.findByMark(mark);
    }

    @Override
    public Car getCarsByModel(Car model) {
        return carRepo.findByModel(model);
    }

    @Override
    public CarCategory getCarsByCategory(Car category) {
        return carCategoryRepo.findByCategory(category);
    }

    @Override
    public Car getCarsByPrice(Car price) {
        return carRepo.findByPrice(price);
    }

    @Override
    public Car getCarsByMileage(Car mileage) {
        return carRepo.findByMileage(mileage);
    }

    @Override
    public Car getCarsByFuel(Car fuel) {
        return carRepo.findByFuel(fuel);
    }

    @Override
    public Car getCarsByYear(Car year) {
        return carRepo.findByYear(year);
    }

    @Override
    public void deleteCar(Car carId) {
        carRepo.delete(carId);
    }
}