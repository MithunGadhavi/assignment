package com.evaluator.car.service;

import org.springframework.stereotype.Service;

import com.evaluator.car.custom.ColorCostEvaluator;
import com.evaluator.car.custom.OffRoadCostEvaluator;
import com.evaluator.car.custom.PriceEvaluator;

@Service
public class CarCostService implements ICarCostService{
	
	@Override
	public Car calculateCarPrice(Car car) {
		
		PriceEvaluator priceEvaluator = new PriceEvaluator(car.getBasePrice());
		
		ColorCostEvaluator colorCostEvaluator = new ColorCostEvaluator(car.getColor());
		
		OffRoadCostEvaluator offRoadCostEvaluator = new OffRoadCostEvaluator(car.getNoOfWheelDrive());
		
		Double finalPrice = 0.0;
		
		String colorPrice = colorCostEvaluator.evaluate(ColorCostEvaluator.expression);
		
		String offRoadPrice = offRoadCostEvaluator.evaluate(OffRoadCostEvaluator.expression);
		
		String price = priceEvaluator.evaluate(PriceEvaluator.expression);
		
		finalPrice = Double.parseDouble(price) + Double.parseDouble(colorPrice) + Double.parseDouble(offRoadPrice);
		
		car.setCarPrice(finalPrice);
		
		return car;
	}

}
