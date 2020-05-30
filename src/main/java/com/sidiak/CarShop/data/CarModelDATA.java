package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarModelDATA {
    @Getter
    private final String model;

    public CarModelDATA(String model) {
        this.model = model;
    }
}
