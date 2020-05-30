package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarFuelDATA {
    @Getter
    private final String fuel;

    public CarFuelDATA(String fuel) {
        this.fuel = fuel;
    }
}
