package com.tka.CarChoice_Hub.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.CarChoice_Hub2.dto.CarUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Car;
import com.tka.CarChoice_Hub2.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("car")
public class CarController {

	@Autowired
	CarService service;

	@PostMapping("insertCar")
	public ResponseEntity<String> insertCar(@Valid @RequestBody Car car) {
		String msg = service.insertCar(car);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCar/{id}")
	public ResponseEntity<String> updateCar(@PathVariable long id, @Valid @RequestBody CarUpdateDTO car) {

		String msg = service.updateCar(id, car);

		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car Id must be greater than zero!");
		}

		if (Objects.isNull(msg)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with Id : " + id);
		}

		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteCar/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable long id) {

		String msg = service.deleteCar(id);

		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car Id must be greater than zero!");
		}

		if (Objects.isNull(msg)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with Id : " + id);
		}

		return ResponseEntity.ok(msg);
	}

	@GetMapping("byId/{id}")
	public ResponseEntity<?> getCarById(@PathVariable long id) {

		Car car = service.getCarById(id);

		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Car Id must be greater than zero!");
		}

		if (Objects.isNull(car)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found with Id : " + id);
		}

		return ResponseEntity.ok(car);
	}

	@GetMapping("getAll")
	public ResponseEntity<List<Car>> getAllCar() {
		List<Car> carList = service.getAllCar();
		return ResponseEntity.ok(carList);
	}

	@GetMapping("price/{startPrice}/{endPrice}")
	public ResponseEntity<?> getCarByPriceRange(@PathVariable double startPrice, @PathVariable double endPrice) {
		Map carRangeList = service.getCarByPriceRange(startPrice, endPrice);

		if (startPrice < 100000) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The price range of the car starts above ₹1 lakh.");
		}

		if (startPrice > endPrice) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid range! The start price cannot be greater than the end price");
		}
		return ResponseEntity.ok(carRangeList);
	}
	
	@PostMapping("exit")
	public void exitApplication() {
		System.out.println("Shutting down the CarChoice-Hub Project...");
		System.exit(0);
	}


}
