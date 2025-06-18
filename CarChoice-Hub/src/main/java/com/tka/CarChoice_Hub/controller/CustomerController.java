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

import com.tka.CarChoice_Hub2.dto.CustomerUpdateDTO;
import com.tka.CarChoice_Hub2.entity.Customer;
import com.tka.CarChoice_Hub2.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("insertCustomer")
	public ResponseEntity<String> insertCustomer(@Valid @RequestBody Customer c) {
		String msg = service.insertCustomer(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable long id, @Valid @RequestBody CustomerUpdateDTO dto) {
		
		String msg = service.updateCustomer(id, dto);

		if (id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Id must be greater than zero!");
		}

		if (Objects.isNull(msg)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with Id :" + id);
		}

		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id){
		
		String msg = service.deleteCustomer(id);
		
		if (id < 0 ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Id must be greater than zero!");
		}
		
		if (Objects.isNull(msg)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with Id : "+id);
		}
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getCustomerById/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable long id){
		
		Customer customer = service.getCustomerById(id);
		
		if (id < 0 ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Id must be greater than zero!");
		}
		
		if (Objects.isNull(customer)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found with Id : "+id);

		}
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping("getAllCustomer")
	public ResponseEntity<List <Customer>> getAllCustomer(){
		List<Customer> customerList = service.getAllCustomer();
		return ResponseEntity.ok(customerList);
	}
	
	@PostMapping("login")
	public ResponseEntity<Map> loginUser(@RequestBody Customer c){
		Map map = service.loginUser(c);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("status/{loanApprovalStatus}")
	public ResponseEntity<Map> getCustomerByLoanApprovalStatus(@PathVariable String loanApprovalStatus) {
		Map statusList = service.getCustomerByLoanApprovalStatus(loanApprovalStatus);
		return ResponseEntity.ok(statusList);
	}
	
	@PostMapping("exit")
	public void exitApplication() {
		System.out.println("Shutting down the CarChoice-Hub Project...");
		System.exit(0);
	}
}
