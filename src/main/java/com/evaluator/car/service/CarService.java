package com.evaluator.car.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluator.car.dataloader.ICarDataLoader;

public class CarService implements ICarService{
	
	@Autowired
	ICarDataLoader carFileDataLoader;
	
	@Autowired
	ICarCostService carCostService;
	
	
	public List<Car> getUpdatedCarList(){
		
		List<Car> carList = carFileDataLoader.prepareCarData();
		
		return carList.stream()
		.map(car -> carCostService.calculateCarPrice(car))
		.sorted(Comparator.comparingInt(Car::getCarNumber))
		.collect(Collectors.toList());
		
	}

}
