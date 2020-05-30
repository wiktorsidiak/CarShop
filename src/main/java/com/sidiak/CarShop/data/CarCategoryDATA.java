package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;
@Data
public class CarCategoryDATA {
    @Getter
    private final String category;

    public CarCategoryDATA(String category) {
        this.category = category;
    }
}
