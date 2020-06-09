package com.sidiak.CarShop.controller;


import com.sidiak.CarShop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    public CarController(CarService carService){
        this.carService = carService;

    }
    public listCars(Model model, @RequestParam(value = "page", defaultValue = "1") int page,)
}
