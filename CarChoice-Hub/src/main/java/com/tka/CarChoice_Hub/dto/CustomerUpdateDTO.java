package com.tka.CarChoice_Hub.dto;

import com.tka.CarChoice_Hub2.entity.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerUpdateDTO {

	private String fullName;

	private String email;

	private String phoneNumber;

	private String address;

	private String pinCode;

	private String paymentMethod;

	private String loanApprovalStatus;

	private Car	car; 
}
