package com.tka.CarChoice_Hub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CarUpdateDTO {
	
	private String fuelType;
	
	private double enginePower;
	
	private double price;
}
