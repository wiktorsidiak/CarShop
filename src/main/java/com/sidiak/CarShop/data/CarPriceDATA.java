package com.sidiak.CarShop.data;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;

@Data
public class CarPriceDATA {
    @Getter
    private final BigDecimal price;

    public CarPriceDATA(BigDecimal price) {
        this.price = price;
    }
}
