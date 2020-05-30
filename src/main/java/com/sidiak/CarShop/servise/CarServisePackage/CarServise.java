package com.sidiak.CarShop.servise.CarServisePackage;

import java.util.List;

import com.sidiak.CarShop.model.Car;

public interface CarServise {
    Car insertCar(Car car);

    Car getByMark(String mark);

    void deleteCar(Long id);

    List<Car> getCarsByMark(String mark);

}
