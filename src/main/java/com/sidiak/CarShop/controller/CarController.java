package com.sidiak.CarShop.controller;

import java.util.List;

import com.sidiak.CarShop.finder.CarData;
import com.sidiak.CarShop.finder.CarFinder;
import com.sidiak.CarShop.model.Car.Car;
import com.sidiak.CarShop.repository.CarRepo;
import com.sidiak.CarShop.service.Car.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

	private final CarFinder carFinder;
	private CarService carService;

	@GetMapping
	public Page<CarData> listCars(Pageable pageable) {

		return carFinder.findAll(pageable);
	}


//	@RequestMapping(value = "/add")
//	public String addCar(Model model) {
//	List<Car> carList = carService.getAll();
//	model.addAttribute("car", new Car());
//
//	return "addcar";
//	}
//
//	@PostMapping(value = "/save")
//	public String save(Car car){
//		carService.save(car);
//
//		return "redirect:cars";
//	}
//
//	@RequestMapping(value = "/findByMark")
//	public String findByCarMark(Model model){
//		carService.getCarsByMark(model mark);
//
}