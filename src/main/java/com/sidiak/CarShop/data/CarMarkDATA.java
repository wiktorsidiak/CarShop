package com.sidiak.CarShop.data;

import lombok.Data;
import lombok.Getter;

@Data
public class CarMarkDATA {
    @Getter
    private final String mark;

    public CarMarkDATA(String mark) {
        this.mark = mark;
    }
}
