package com.sidiak.CarShop.data;

import java.util.Date;

import lombok.Data;
import lombok.Getter;

@Data
public class CarCreatedAtDATA {
    @Getter
    private final Date createdAt;

    public CarCreatedAtDATA(Date createdAt) {
        this.createdAt = createdAt;
    }
}
