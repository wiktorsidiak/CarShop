package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarVinCodeDATA {
    @Getter
    private final String vinCode;

    public CarVinCodeDATA(String vinCode) {
        this.vinCode = vinCode;
    }
}
