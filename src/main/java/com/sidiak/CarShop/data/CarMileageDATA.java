package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarMileageDATA {
    @Getter
    private final Integer mileage;

    public CarMileageDATA(Integer mileage) {
        this.mileage = mileage;
    }
}
