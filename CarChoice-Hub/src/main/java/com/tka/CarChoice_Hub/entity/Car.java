package com.tka.CarChoice_Hub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Brand is required")
	private String brand;

	@NotBlank(message = "Model is required")
	private String model;

	@NotBlank(message = "Fuel Type is required")
	private String fuelType;

	@Min(value = 2, message = "Seat capacity must be at least 2")
	private int seatCapacity;

	@Positive(message = "Engine power must be greater than 0")
	private double enginePower;

	@Positive(message = "Price must be greater than 0")
	private double price;

}
