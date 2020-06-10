package com.sidiak.CarShop.controller;

import com.sidiak.CarShop.finder.CarData;
import com.sidiak.CarShop.finder.CarFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarFinder carFinder;

    @GetMapping
    public Page<CarData> listCars(Pageable pageable) {
        return carFinder.findAll(pageable);
    }
}
