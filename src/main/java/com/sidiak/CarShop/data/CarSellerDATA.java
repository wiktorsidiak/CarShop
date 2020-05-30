package com.sidiak.CarShop.data;

import com.sidiak.CarShop.model.Seller;
import lombok.Data;
import lombok.Getter;

@Data
public class CarSellerDATA {
    @Getter
    private final Seller seller;

    public CarSellerDATA(Seller seller) {
        this.seller = seller;
    }
}
