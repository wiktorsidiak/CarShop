package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;


public class CarDATA {
    @Getter
    private CarIdDATA id;

    @Getter
    private CarMarkDATA mark;

    @Getter
    private CarModelDATA model;

    @Getter
    private CarCategoryDATA category;

    @Getter
    private CarPriceDATA price;

    @Getter
    private CarVinCodeDATA vinCode;

    @Getter
    private CarYearDATA year;

    @Getter
    private CarMileageDATA mileage;

    @Getter
    private CarFuelDATA fuel;

    @Getter
    private CarCreatedAtDATA createdAt;

    @Getter
    private CarUpdeatedAtDATA updeatedAt;

    public CarDATA(CarIdDATA id, CarMarkDATA mark, CarModelDATA model,
                   CarCategoryDATA category, CarPriceDATA price, CarVinCodeDATA vinCode,
                   CarYearDATA year, CarMileageDATA mileage, CarFuelDATA fuel,
                   CarCreatedAtDATA createdAt, CarUpdeatedAtDATA updeatedAt) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.category = category;
        this.price = price;
        this.vinCode = vinCode;
        this.year = year;
        this.mileage = mileage;
        this.fuel = fuel;
        this.createdAt = createdAt;
        this.updeatedAt = updeatedAt;
    }
}
