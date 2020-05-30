package com.sidiak.CarShop.data;

import java.util.Date;

import lombok.Data;
import lombok.Getter;

@Data
public class CarUpdeatedAtDATA {
    @Getter
    private final Date updeatedAt;

    public CarUpdeatedAtDATA(Date updeatedAt) {
        this.updeatedAt = updeatedAt;
    }
}
