package com.evaluator.car.dataloader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evaluator.car.service.Car;

@Component
public class CarFileDataLoader implements ICarDataLoader {

	private String carFilePath = "";

	@Override
	public List<Car> prepareCarData() {
		
		//TODO
		//Read and Validate file
		
		List carList = new ArrayList<Car>();
		
		carList.add(Car.builder().carNumber(3).basePrice(200).color("RED").
				isAmphibious(false).noOfWheelDrive(4).build());
		
		carList.add(Car.builder().carNumber(5).basePrice(400).color("BLACK").
				isAmphibious(true).noOfWheelDrive(4).build());
		
		carList.add(Car.builder().carNumber(10).basePrice(200).color("PINK").
				isAmphibious(false).noOfWheelDrive(2).build());
		
		carList.add(Car.builder().carNumber(20).basePrice(200).color("BLUE").
				isAmphibious(true).noOfWheelDrive(4).build());
		
		return carList;
	}

}
