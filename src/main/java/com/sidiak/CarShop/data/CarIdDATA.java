package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarIdDATA {
    @Getter
    private final Long id;

    public CarIdDATA(Long id) {
        this.id = id;
    }
}
