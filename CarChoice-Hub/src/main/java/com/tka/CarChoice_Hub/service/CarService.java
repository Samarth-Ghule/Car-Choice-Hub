package com.tka.CarChoice_Hub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.CarChoice_Hub2.dao.CarDao;
import com.tka.CarChoice_Hub2.dto.CarUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Car;

import jakarta.validation.Valid;

@Service
public class CarService {
	
	@Autowired
	CarDao dao;

	public String insertCar(Car car) {
		String msg = dao.insertCar(car);
		return msg;
	}

	public String updateCar(long id, CarUpdateDTO car) {
		String msg = dao.updateCar(id, car);
		return msg;
	}

	public String deleteCar(long id) {
		String msg = dao.deleteCar(id);
		return msg;
	}

	public Car getCarById(long id) {
		Car car = dao.getCarById(id);
		return car;
	}

	public List<Car> getAllCar() {
		List <Car> carList = dao.getAllCar();
		return carList;
	}

	public Map getCarByPriceRange(double startPrice, double endPrice) {
		
		List<Car> allCar = dao.getAllCar();
		List<Car> carRangeList = new ArrayList<Car>();
		
		Map map = new HashMap<>();
		
		for (Car car : allCar) {
			if (car.getPrice() >= startPrice && car.getPrice() <= endPrice ) {
				carRangeList.add(car);
			}
		}
		
		
		if (!carRangeList.isEmpty()) {
			map.put("msg", "Price Range : " +startPrice+" - "+endPrice);
			map.put("Available Cars : ", carRangeList);
		}else {
			map.put("msg", startPrice+" - "+endPrice+" Car Not Available in this Range, Please Enter Valid Range !");
			map.put("Available Cars : ", carRangeList);

		}
		
		return map;
	}

}
