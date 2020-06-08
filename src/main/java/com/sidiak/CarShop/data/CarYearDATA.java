package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class CarYearDATA {
    @Getter
    private final Integer year;

    public CarYearDATA(Integer year) {
        assert year > 0 : "Year can't be less than 0";
        assert year <= LocalDate.now().getYear() : "Car production year can't be from future";
        this.year = year;
    }
}
