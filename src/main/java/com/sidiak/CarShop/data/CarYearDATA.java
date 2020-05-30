package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarYearDATA {
    @Getter
    private final Integer year;

    public CarYearDATA(Integer year) {
        this.year = year;
    }
}
